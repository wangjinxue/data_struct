package me.wjx.design_mode.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wjx
 * @date 2018/7/27 16:50
 */
public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons=new ArrayList<>();
        for(Person person: persons){
            if(person.getGender().equalsIgnoreCase("MALE")){
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
