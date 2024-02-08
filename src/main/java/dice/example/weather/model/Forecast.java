package dice.example.weather.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Forecast{
    public ArrayList<Item> items;
    public Date forecastDate;
    public Date nextUpdate;
    public String source;
    public String point;
    public String fingerprint;
}
