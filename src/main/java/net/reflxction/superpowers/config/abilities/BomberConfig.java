package net.reflxction.superpowers.config.abilities;

import net.reflxction.superpowers.config.IAbilityConfigHandler;
import net.reflxction.superpowers.core.AbilityType;

/**
 * Created by Reflxction, on 02/15/18.
 */
public class BomberConfig implements IAbilityConfigHandler {

    @Override
    public AbilityType getAbility() {
        return AbilityType.BOMBER;
    }

    public int getChance() {
        return getInt("Abilities.Bomber.Chance");
    }

}
