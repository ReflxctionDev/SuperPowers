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

package net.reflxction.superpowers.abilities;

import net.reflxction.superpowers.core.SuperPowers;
import net.reflxction.superpowers.gui.AbilityGUI;
import net.reflxction.superpowers.utils.CheckUtils;
import net.reflxction.superpowers.utils.managers.ConfigVariables;
import net.reflxction.superpowers.utils.managers.MessageManager;
import net.reflxction.superpowers.utils.managers.StringManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

/**
 * Represents the /ability command, which opens a GUI to select abilities
 */

public class AbilityCommand implements CommandExecutor {

    // Main class instance
    private SuperPowers m;


    public AbilityCommand(SuperPowers m) {
        // Use the static method if the constructor fails
        this.m = (m == null) ? SuperPowers.getPlugin(SuperPowers.class) : m;
    }

    // Instance of the ability GUI
    private AbilityGUI a = new AbilityGUI(m);

    // Instance of the message manager
    private MessageManager mm = new MessageManager(m);

    // Instance of the main config variables
    private ConfigVariables c = new ConfigVariables(m);

    // Instance of the String manager utility
    private StringManager su = new StringManager();

    // Cooldown hashmaps
    private HashMap<UUID, Integer> cooldownTime = new HashMap<>();
    private HashMap<UUID, BukkitRunnable> cooldownTask = new HashMap<>();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if the sender is a player
        if (!CheckUtils.isPlayer(sender)) {
            // Send the message if they weren't
            sender.sendMessage(mm.getNotPlayerMessage());
        }
        // Checking if it's a player
        else {
            // Casting the sender to a player to use the player methods
            Player p = (Player) sender;
            // Checking if they have the permission to use the command
            if (p.hasPermission("superpowers.abilities.command")) {
                // CHeck if their delay isn't over yet
                if (cooldownTime.containsKey(p.getUniqueId())) {
                    // Send the delay message
                    p.sendMessage(su.format(su.filter("&cThis command is on cooldown! Time left: &c&l{time_left}", p, cooldownTime.get(p.getUniqueId()))));
                    return true;
                } else {
                    // Instance of the player's uuid, after checking if they have no more delay
                    final UUID uuid = p.getUniqueId();
                    // Put the uuid to the maps
                    cooldownTime.put(uuid, c.getAbilityCommandCooldown());
                    cooldownTask.put(uuid, new BukkitRunnable() {
                        public void run() {
                            cooldownTime.put(uuid, cooldownTime.get(uuid) - 1);
                            if (cooldownTime.get(uuid) == 0) {
                                cooldownTime.remove(uuid);
                                cooldownTask.remove(uuid);
                                cancel();
                            }
                        }
                    });
                    cooldownTask.get(uuid).runTaskTimer(m, 20, 20);
                    // After putting the delay, open the GUI
                    a.openGUI(p);
                    return true;
                }
            } else {
                // After checking if they don't have permission, send the message
                p.sendMessage(mm.getNoPermissionCmdMessage());
            }
        }
        return false;
    }
}
