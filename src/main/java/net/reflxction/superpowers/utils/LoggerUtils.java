/*
 * * Copyright 2018 github.com/ReflxctionDev
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

package net.reflxction.superpowers.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class LoggerUtils {

    public static void log(String s) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', s));
    }

    public static void debug(String node, Object s) {
        log("&1[SuperPowers Debugger] &c[" + node + "] &0" + s);
    }

    public static void debug(int node, Object s) {
        log("&1[SuperPowers Debugger] &c[" + node + "] &0" + s);
    }

}
