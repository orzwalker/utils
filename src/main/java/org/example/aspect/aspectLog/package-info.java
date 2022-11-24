/**
 * 切面日志记录
 * 要求记录变更订单时的订单id，不入侵业务逻辑
 * 比如rank中的doctorId
 *
 * 存的问题
 * 1、主业务逻辑发生了异常，切面逻辑没有回滚
 *
 *
 * @author walker
 * @since 2022/11/21 11:25
 */
package org.example.aspect.aspectLog;