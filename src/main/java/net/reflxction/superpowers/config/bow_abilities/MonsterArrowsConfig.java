/*
 * * Copyright 2017-2018 github.com/ReflxctionDev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.reflxction.superpowers.config.bow_abilities;

import net.reflxction.superpowers.config.IBowAbiliyConfigHandler;
import net.reflxction.superpowers.core.BowAbility;
import net.reflxction.superpowers.core.SuperPowers;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.List;

public class MonsterArrowsConfig implements IBowAbiliyConfigHandler {

    private SuperPowers m;

    public MonsterArrowsConfig(SuperPowers m) {
        this.m = (m == null) ? SuperPowers.getPlugin(SuperPowers.class) : m;
    }

    @Override
    public BowAbility getAbility() {
        return BowAbility.MONSTER_ARROWS;
    }

    public int getChance() {
        return getInt("BowAbilities.MonsterArrows.Chance");
    }

    public List<EntityType> getEntitiesList() {
        List<String> sList = getList("BowAbilities.MonsterArrows.EntitiesToSpawn");
        List<EntityType> entitiesList = new ArrayList<>();
        sList.forEach(s -> entitiesList.add(BowAbility.getEntityByName(s)));
        return entitiesList;
    }

    @Override
    public SuperPowers getPlugin() {
        return m;
    }
}
