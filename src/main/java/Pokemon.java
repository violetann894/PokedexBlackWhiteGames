

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity
@Table(name = "Pokemon")
public class Pokemon {
    @Id
    private int pokedexId;
    private String name;
    private String species;
    private String[] types = new String[2];
    private String imageSource;
    private String blackDescription;
    private String whiteDescription;

    // Constructors, getters, and setters
    public Pokemon() {
    	
    }

    public Pokemon(String name, int number, String species, String[] types, String image, String blackDescription, String whiteDescription) {
        this.pokedexId = number;
        this.name = name;
        this.species = species;
        this.types = types;
        this.setImageSource(image);
        this.blackDescription = blackDescription;
        this.whiteDescription = whiteDescription;
    }

	public int getPokedexId() {
		return pokedexId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBlackDescription() {
		return blackDescription;
	}

	public void setBlackDescription(String blackDescription) {
		this.blackDescription = blackDescription;
	}

	public String getWhiteDescription() {
		return whiteDescription;
	}

	public void setWhiteDescription(String whiteDescription) {
		this.whiteDescription = whiteDescription;
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}

	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}
	
	@Override
	public String toString() {
		if(this.pokedexId < 10) {
			return String.format("#00%d %s", this.pokedexId, name);
		}else if(pokedexId < 100) {
			return String.format("#0%d %s", this.pokedexId, name);
		}
		return String.format("#%d %s", this.pokedexId, name);
	}
}
