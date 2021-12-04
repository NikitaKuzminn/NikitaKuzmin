package home.epam.hw9.entities;

import lombok.Data;

@Data
public class ListDto {

    private String id;
    private String name;
    private Boolean closed;
    private Integer pos;
    private String idBoard;
}
