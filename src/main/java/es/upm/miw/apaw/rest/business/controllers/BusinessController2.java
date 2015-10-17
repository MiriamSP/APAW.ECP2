package es.upm.miw.apaw.rest.business.controllers;

import es.upm.miw.apaw.rest.data.models.daos.DaoFactory;
import es.upm.miw.webArchitecture.rest.business.views.TransferObject1;
import es.upm.miw.webArchitecture.rest.business.views.TransferObject2;

public class BusinessController2 {

    public TransferObject2 m1() {
        DaoFactory.getFactory().getEntity1Dao().findAll();
        return new TransferObject2();
    }

    public void m2(TransferObject1 transferObject1) {
        DaoFactory.getFactory().getEntity2Dao().read(1);
    }
}
