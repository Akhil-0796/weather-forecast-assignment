package dice.example.weather.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Temperature{
    public int min;
    public int max;
    public Object avg;
}
