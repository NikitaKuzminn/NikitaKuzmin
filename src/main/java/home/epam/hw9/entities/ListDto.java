package home.epam.hw9.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ListDto {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("closed")
    @Expose
    private Boolean closed;

    @SerializedName("pos")
    @Expose
    private Integer pos;

    @SerializedName("idBoard")
    @Expose
    private String idBoard;
}
