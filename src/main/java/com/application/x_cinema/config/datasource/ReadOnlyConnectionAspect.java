//package com.application.x_cinema.config.datasource;
//
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class ReadOnlyConnectionAspect {
//
//    @Before("@annotation(readOnlyConnection)")
//    public void setReadOnlyDataSource(ReadOnlyConnection readOnlyConnection) {
//        DataSourceContextHolder.set(DataSourceType.SLAVE);
//    }
//
//    @After("@annotation(readOnlyConnection)")
//    public void clearDataSource(ReadOnlyConnection readOnlyConnection) {
//        DataSourceContextHolder.clear();
//    }
//}
