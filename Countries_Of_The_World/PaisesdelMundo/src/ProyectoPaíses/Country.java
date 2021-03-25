package ProyectoPaíses;
public class Country {

    private String nameCountry, continent, capital, language,population,description;
 
    public Country(String nameCountry, String continent, String capital, String language, String population, String description) {
        this.nameCountry = nameCountry;
        this.continent = continent;
        this.capital = capital;
        this.language = language;
        this.population = population;
        this.description = description;
       
    }//End Country

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}//End Country
