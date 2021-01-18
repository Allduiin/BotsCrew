package model;

import java.util.List;
import lombok.Data;

@Data
public class Department {
    private List<Lector> lectors;
    private String name;
    private Lector headOfDepartment;
}
