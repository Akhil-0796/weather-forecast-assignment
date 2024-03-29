package dice.example.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prec{
    public double sum;
    public int probability;
    public Object sumAsRain;
    @JsonProperty("class")
    public int myclass;
}
