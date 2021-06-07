package pojosNbodies.petPojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import java.util.List;

@Getter @ToString
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pets {
    private int id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tags> tags;
    private String status;


}
