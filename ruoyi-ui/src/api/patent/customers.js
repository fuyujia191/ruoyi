import request from '@/utils/request'

// 查询客户列表列表
export function listCustomers(query) {
  return request({
    url: '/patent/customers/list',
    method: 'get',
    params: query
  })
}

// 查询客户列表详细
export function getCustomers(id) {
  return request({
    url: '/patent/customers/' + id,
    method: 'get'
  })
}

// 新增客户列表
export function addCustomers(data) {
  return request({
    url: '/patent/customers',
    method: 'post',
    data: data
  })
}

// 修改客户列表
export function updateCustomers(data) {
  return request({
    url: '/patent/customers',
    method: 'put',
    data: data
  })
}

// 删除客户列表
export function delCustomers(id) {
  return request({
    url: '/patent/customers/' + id,
    method: 'delete'
  })
}
