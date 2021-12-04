package home.epam.hw9.entities;

import lombok.Data;

@Data
public class BoardDto {

    private String id;
    private String name;
    private String desc;
    private Object descData;
    private Boolean closed;
    private String idOrganization;
    private Object idEnterprise;
    private Boolean pinned;
    private String url;
    private String shortUrl;
}
