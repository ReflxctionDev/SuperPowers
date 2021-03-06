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

package net.reflxction.superpowers.gui;

import net.reflxction.superpowers.config.abilities.*;
import net.reflxction.superpowers.core.SuperPowers;
import net.reflxction.superpowers.utils.managers.ConfigVariables;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class AbilityGUI {

    private SuperPowers m;

    public AbilityGUI(SuperPowers m) {
        this.m = (m == null) ? SuperPowers.getPlugin(SuperPowers.class) : m;
    }

    private final ConfigVariables c = new ConfigVariables(m);

    /**
     * @param p Player to open the inventory for
     */
    public void openGUI(Player p) {
        final Inventory gui = Bukkit.createInventory(null, 45, ChatColor.translateAlternateColorCodes('&', c.getAbilitiesGuiName()));
        BomberConfig bc = new BomberConfig(m);
        FirePunchConfig fc = new FirePunchConfig(m);
        InvisibleCloakConfig ic = new InvisibleCloakConfig(m);
        IronFistConfig ifc = new IronFistConfig(m);
        ThorConfig tc = new ThorConfig(m);
        VampireConfig vc = new VampireConfig(m);
        gui.setItem(bc.getSlot(), bc.getOverallItem());
        gui.setItem(fc.getSlot(), fc.getOverallItem());
        gui.setItem(ic.getSlot(), ic.getOverallItem());
        gui.setItem(ifc.getSlot(), ifc.getOverallItem());
        gui.setItem(tc.getSlot(), tc.getOverallItem());
        gui.setItem(vc.getSlot(), vc.getOverallItem());
        p.openInventory(gui);
    }
}
