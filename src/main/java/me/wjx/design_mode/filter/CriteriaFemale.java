package me.wjx.design_mode.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wjx
 * @date 2018/7/27 16:51
 */
public class CriteriaFemale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons=new ArrayList<>();
        for(Person person:persons){
            if(person.getGender().equalsIgnoreCase("FEMALE")){
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
