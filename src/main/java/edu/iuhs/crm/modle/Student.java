package edu.iuhs.crm.modle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;
    private String name;
    private String age;
    private String contact;
    private String pname;
    private String paddress;
    private String pcontact;

    public boolean customNullValue(Student student){

         return (
                        student.name == null ||
                        student.age == null ||
                        student.contact == null ||
                        student.pname == null ||
                        student.paddress == null ||
                        student.pcontact == null ||
                        student.name.isEmpty()  ||
                        student.age.isEmpty() ||
                        student.contact.isEmpty() ||
                        student.pname.isEmpty() ||
                        student.paddress.isEmpty() ||
                        student.pcontact.isEmpty()
        ) ? true: false;
    }
}
