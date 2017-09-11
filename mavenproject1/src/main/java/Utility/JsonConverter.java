/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Entity.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

/**
 *
 * @author Farkas
 */
public class JsonConverter {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static Person getPersonFromJson(String js) {
        return new Person();
    }

    public static String getJSONFromPerson(Person p) {
        return "Not yet supported";
    }

    public static String getJSONFromPerson(List<Person> persons) {
        return gson.toJson(persons);
    }

}
