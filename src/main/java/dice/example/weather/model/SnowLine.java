package dice.example.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SnowLine{
    public Object avg;
    public Object min;
    public Object max;
    public String unit;
}
