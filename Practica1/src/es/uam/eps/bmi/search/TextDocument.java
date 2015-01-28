package es.uam.eps.bmi.search;

import java.util.Objects;

public class TextDocument {
    String id;
    String name;
    
    public TextDocument (String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public boolean equals (Object object) {
        if (!(object instanceof TextDocument)) {
            return false;
        }
        return id.equals(((TextDocument)object).getId());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
}
