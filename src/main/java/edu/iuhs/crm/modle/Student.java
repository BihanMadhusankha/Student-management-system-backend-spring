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
}
