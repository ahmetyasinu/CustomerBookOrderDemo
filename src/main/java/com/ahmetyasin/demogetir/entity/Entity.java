package com.ahmetyasin.demogetir.entity;

import java.io.Serializable;

public interface Entity<PK extends Serializable> {

    PK getID();

    void setID(PK ID);

}
