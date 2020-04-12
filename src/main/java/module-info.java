open module com.k8s.bookstore.adminapp {
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.context;
    requires spring.web;

    requires spring.data.jpa;
    requires spring.data.commons;
    requires java.persistence;
    requires org.hibernate.orm.core;
    requires java.sql;

    requires static lombok;
}