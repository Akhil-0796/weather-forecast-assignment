package dice.example.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location{
    public String code;
    public String name;
    public String timezone;
    public Coordinates coordinates;
}
