<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">

      <el-row>
        <el-col :span="4">
      <el-form-item label="客户名称" prop="customerName">
        <el-input
          v-model="queryParams.customerName"
          placeholder="请输入客户名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
        </el-col>
        <el-col :span="4">
      <el-form-item label="联系人" prop="relationPerson">
        <el-input
          v-model="queryParams.relationPerson"
          placeholder="请输入联系人"
          clearable
          @keyup.enter.native="handleQuery"
        />

      </el-form-item>
        </el-col>
      <!--<el-form-item label="部门" prop="departId">-->
        <!--<el-input-->
          <!--v-model="queryParams.departId"-->
          <!--placeholder="请选择部门"-->
          <!--clearable-->
          <!--@keyup.enter.native="handleQuery"-->
        <!--/>-->
      <!--</el-form-item>-->
        <el-col :span="4">
      <el-form-item label="" prop="deptId">
        <treeselect v-model="queryParams.departId" :options="deptOptions" :show-count="true" placeholder="选择部门"
                    @keyup.enter.native="handleQuery"/>
      </el-form-item>
      </el-col>
        <el-col :span="4">
      <el-form-item label="" prop="personId">
        <treeselect v-model="queryParams.personId" :options="deptOptions" :show-count="true" placeholder="选择员工"
                    @keyup.enter.native="handleQuery"/>
      </el-form-item>
        </el-col>

      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
      </el-form-item>

      </el-row>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['patent:customers:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['patent:customers:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['patent:customers:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['patent:customers:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>
    <el-table v-loading="loading" :data="customersList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="ID" align="center" prop="id"/>
      <el-table-column label="客户名称" align="center" prop="customerName"/>
      <el-table-column label="地址" align="center" prop="address"/>
      <el-table-column label="联系人" align="center" prop="relationPerson"/>
      <el-table-column label="电话" align="center" prop="mobile"/>
      <el-table-column label="手机" align="center" prop="tel"/>
      <el-table-column label="所属部门" align="center" prop="departId"/>
      <el-table-column label="所属员工" align="center" prop="personId"/>
      <el-table-column label="跟进状态" align="center" prop="status"/>
      <el-table-column label="最后跟进时间" align="center" prop="lastrelationtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lastrelationtime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['patent:customers:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['patent:customers:remove']"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改客户列表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="${comment}" prop="customerName">
          <el-input v-model="form.customerName" placeholder="请输入${comment}"/>
        </el-form-item>
        <el-form-item label="${comment}" prop="address">
          <el-input v-model="form.address" placeholder="请输入${comment}"/>
        </el-form-item>
        <el-form-item label="${comment}" prop="relationPerson">
          <el-input v-model="form.relationPerson" placeholder="请输入${comment}"/>
        </el-form-item>
        <el-form-item label="${comment}" prop="mobile">
          <el-input v-model="form.mobile" placeholder="请输入${comment}"/>
        </el-form-item>
        <el-form-item label="${comment}" prop="tel">
          <el-input v-model="form.tel" placeholder="请输入${comment}"/>
        </el-form-item>
        <el-form-item label="${comment}" prop="relationPerson2">
          <el-input v-model="form.relationPerson2" placeholder="请输入${comment}"/>
        </el-form-item>
        <el-form-item label="${comment}" prop="mobile2">
          <el-input v-model="form.mobile2" placeholder="请输入${comment}"/>
        </el-form-item>
        <el-form-item label="${comment}" prop="tel2">
          <el-input v-model="form.tel2" placeholder="请输入${comment}"/>
        </el-form-item>
        <el-form-item label="${comment}" prop="departId">
          <el-input v-model="form.departId" placeholder="请输入${comment}"/>
        </el-form-item>
        <el-form-item label="${comment}" prop="personId">
          <el-input v-model="form.personId" placeholder="请输入${comment}"/>
        </el-form-item>
        <el-form-item label="${comment}" prop="adddate">
          <el-date-picker clearable
                          v-model="form.adddate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择${comment}">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="${comment}" prop="editdate">
          <el-date-picker clearable
                          v-model="form.editdate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择${comment}">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="${comment}" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入${comment}"/>
        </el-form-item>
        <el-form-item label="${comment}" prop="limitdate">
          <el-date-picker clearable
                          v-model="form.limitdate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择${comment}">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="${comment}" prop="lastrelationtime">
          <el-date-picker clearable
                          v-model="form.lastrelationtime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择${comment}">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="${comment}" prop="relationPersonid">
          <el-input v-model="form.relationPersonid" placeholder="请输入${comment}"/>
        </el-form-item>
        <el-form-item label="${comment}" prop="wx">
          <el-input v-model="form.wx" placeholder="请输入${comment}"/>
        </el-form-item>
        <el-form-item label="${comment}" prop="qq">
          <el-input v-model="form.qq" placeholder="请输入${comment}"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import {listCustomers, getCustomers, delCustomers, addCustomers, updateCustomers} from "@/api/patent/customers";
  import { treeselect } from "@/api/system/dept";
  import Treeselect from "@riophae/vue-treeselect";
  import "@riophae/vue-treeselect/dist/vue-treeselect.css";

  export default {
    name: "Customers",
    components: { Treeselect },
    data() {
      return {
        // 遮罩层
        loading: true,
        // 选中数组
        ids: [],
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 客户列表表格数据
        customersList: [],
        // 部门树选项
        deptOptions: undefined,
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          customerName: null,
          relationPerson: null
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {}
      };
    },
    created() {
      this.getTreeselect();
      this.getList();
    },
    methods: {
      /** 查询客户列表列表 */
      getList() {
        this.loading = true;
        listCustomers(this.queryParams).then(response => {
          this.customersList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
      },
      // 取消按钮
      cancel() {
        this.open = false;
        this.reset();
      },
      // 表单重置
      reset() {
        this.form = {
          customerName: null,
          relationPerson: null
        };
        this.resetForm("form");
      },
      /** 查询部门下拉树结构 */
      getTreeselect() {
        treeselect().then(response => {
          this.deptOptions = response.data;
        });
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.pageNum = 1;
        this.getList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.resetForm("queryForm");
        this.handleQuery();
      },
      // 多选框选中数据
      handleSelectionChange(selection) {
        this.ids = selection.map(item => item.id)
        this.single = selection.length !== 1
        this.multiple = !selection.length
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加客户列表";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const id = row.id || this.ids
        getCustomers(id).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改客户列表";
        });
      },
      /** 提交按钮 */
      submitForm() {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.id != null) {
              updateCustomers(this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              });
            } else {
              addCustomers(this.form).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }
          }
        });
      },
      /** 删除按钮操作 */
      handleDelete(row) {
        const ids = row.id || this.ids;
        this.$modal.confirm('是否确认删除客户列表编号为"' + ids + '"的数据项？').then(function () {
          return delCustomers(ids);
        }).then(() => {
          this.getList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {
        });
      },
      /** 导出按钮操作 */
      handleExport() {
        this.download('patent/customers/export', {
          ...this.queryParams
        }, `customers_${new Date().getTime()}.xlsx`)
      }
    }
  };
</script>
