package webprotocol;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Geo {

    @SerializedName("lat")
    private double latitude;

    @SerializedName("lgn")
    private double longitude;
}
