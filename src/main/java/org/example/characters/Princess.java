package org.example.characters;

public class Princess extends Character {
    private Boolean isWithTheHero;

    public Princess(String name, Boolean isLiving, Boolean isWithTheHero) {
        super(name, isLiving);
        this.isWithTheHero = isWithTheHero;
    }

    public Boolean getWithTheHero() {
        return isWithTheHero;
    }

    public void setWithTheHero(Boolean withTheHero) {
        isWithTheHero = withTheHero;
    }
}
