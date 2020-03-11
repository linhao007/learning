package com.linhao007.www.ListenerPattern;

/**
 * @author: linhu@kanzhun.com
 * @date: 2020/3/11 10:15
 * @description: 事件
 */
public class Even {
    private Person person;

    public Even(Person person) {
        super();
        this.person = person;
    }

    public Even() {
        super();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
