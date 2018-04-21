
package com.educationit.java.standard.integrator.service;


import java.util.List;


public interface IMercadolibreRestService<T, R> {


    List<T> getCategories ();

    List<R> getStores ();
}