package me.jayie.arcanecolors.Commands;

import me.jayie.arcanecolors.ArcaneColors;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class playerCommands implements CommandExecutor {

    private final ArcaneColors plugin;
    public playerCommands(ArcaneColors plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String invalidArgument = plugin.getConfig().getString("Errors.InvalidArgument");
        String prefix = plugin.getConfig().getString("Plugin.Prefix");
        String allcolorperm = plugin.getConfig().getString("Plugin.Permissions.Color.Set");
        String certaincolorperm = plugin.getConfig().getString("Plugin.Permissions.Color.CertainColor");
        String everyperm = plugin.getConfig().getString("Plugin.Permissions.Admin.AllPerms");
        String hexperm = plugin.getConfig().getString("Plugin.Permissions.Color.Hex");
        String success = plugin.getConfig().getString("Messages.Color.Success");
        String noperm = plugin.getConfig().getString("Errors.NoPermission");

        if (sender instanceof Player){
            Player player = (Player) sender;




            if (command.getName().equalsIgnoreCase("color")){

                PreparedStatement colorset = null;
                PreparedStatement boldset = null;
                PreparedStatement italicset = null;
                PreparedStatement magicset = null;
                PreparedStatement underlineset = null;
                PreparedStatement strikethroughset = null;
                try {
                    colorset = plugin.DB.getConnection().prepareStatement("UPDATE chatcolor(color) VALUES (?)");
                    boldset = plugin.DB.getConnection().prepareStatement("UPDATE chatcolor(bold) VALUES (?)");
                    italicset = plugin.DB.getConnection().prepareStatement("UPDATE chatcolor(italic) VALUES (?)");
                    magicset = plugin.DB.getConnection().prepareStatement("UPDATE chatcolor(magic) VALUES (?)");
                    underlineset = plugin.DB.getConnection().prepareStatement("UPDATE chatcolor(underline) VALUES (?)");
                    strikethroughset = plugin.DB.getConnection().prepareStatement("UPDATE chatcolor(strikethrough) VALUES (?)");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (args.length < 1){
                    invalidArgument.replace("%prefix%", prefix);
                    player.sendMessage(Color(Hex(invalidArgument)));
                }

                if (args[0].equalsIgnoreCase("set")) {


                    if (args[1].equalsIgnoreCase("darkblue") || args[1].equalsIgnoreCase("1")) {
                        certaincolorperm.replace("%color-name%", "darkblue");
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {
                            try {
                                colorset.setString(1, "1");
                                success.replace("%color%", "&1");
                                player.sendMessage(Color(Hex(success)));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }
                    } else if (args[1].equalsIgnoreCase("darkgreen") || args[1].equalsIgnoreCase("2")) {
                        certaincolorperm.replace("%color-name%", "darkgreen");
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {
                            try {
                                colorset.setString(1, "2");
                                success.replace("%color%", "&2");
                                player.sendMessage(Color(Hex(success)));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }
                    } else if (args[1].equalsIgnoreCase("cyan") || args[1].equalsIgnoreCase("3")) {
                        certaincolorperm.replace("%color-name%", "cyan");
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {
                            try {
                                colorset.setString(1, "3");
                                success.replace("%color%", "&3");
                                player.sendMessage(Color(Hex(success)));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("darkred") || args[1].equalsIgnoreCase("4")) {
                        certaincolorperm.replace("%color-name%", "darkred");
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(everyperm)) {
                            try {
                                colorset.setString(1, "4");
                                success.replace("%color%", "&4");
                                player.sendMessage(Color(Hex(success)));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("purple") || args[1].equalsIgnoreCase("5")) {
                        certaincolorperm.replace("%color-name%", "purple");
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {
                            try {
                                colorset.setString(1, "5");
                                success.replace("%color%", "&5");
                                player.sendMessage(Color(Hex(success)));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("gold") || args[1].equalsIgnoreCase("6")) {
                        certaincolorperm.replace("%color-name%", "gold");
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {
                            try {
                                colorset.setString(1, "6");
                                success.replace("%color%", "&6");
                                player.sendMessage(Color(Hex(success)));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("lightgray") || args[1].equalsIgnoreCase("7")) {
                        certaincolorperm.replace("%color-name%", "lightgray");
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {
                            try {
                                colorset.setString(1, "7");
                                success.replace("%color%", "&7");
                                player.sendMessage(Color(Hex(success)));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("gray") || args[1].equalsIgnoreCase("8")) {
                        certaincolorperm.replace("%color-name%", "gray");
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {
                            try {
                                colorset.setString(1, "8");
                                success.replace("%color%", "&8");
                                player.sendMessage(Color(Hex(success)));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("pastelblue") || args[1].equalsIgnoreCase("9")) {
                        certaincolorperm.replace("%color-name%", "pastelblue");
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {
                            try {
                                colorset.setString(1, "9");
                                success.replace("%color%", "&9");
                                player.sendMessage(Color(Hex(success)));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("black") || args[1].equalsIgnoreCase("0")) {
                        certaincolorperm.replace("%color-name%", "black");
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {
                            try {
                                colorset.setString(1, "0");
                                success.replace("%color%", "0");
                                player.sendMessage(Color(Hex(success)));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("lime") || args[1].equalsIgnoreCase("a")) {
                        certaincolorperm.replace("%color-name%", "lime");
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {
                            try {
                                colorset.setString(1, "a");
                                success.replace("%color%", "&a");
                                player.sendMessage(Color(Hex(success)));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("aqua") || args[1].equalsIgnoreCase("b")) {
                        certaincolorperm.replace("%color-name%", "aqua");
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {
                            try {
                                colorset.setString(1, "b");
                                success.replace("%color%", "&b");
                                player.sendMessage(Color(Hex(success)));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("red") || args[1].equalsIgnoreCase("c")) {
                        certaincolorperm.replace("%color-name%", "red");
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(everyperm)) {
                            try {
                                colorset.setString(1, "c");
                                success.replace("%color%", "&c");
                                player.sendMessage(Color(Hex(success)));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("pink") || args[1].equalsIgnoreCase("d")) {
                        certaincolorperm.replace("%color-name%", "pink");
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {
                            try {
                                colorset.setString(1, "d");
                                success.replace("%color%", "&d");
                                player.sendMessage(Color(Hex(success)));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("yellow") || args[1].equalsIgnoreCase("e")) {
                        certaincolorperm.replace("%color-name%", "yellow");
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {
                            try {
                                colorset.setString(1, "e");
                                success.replace("%color%", "&f");
                                player.sendMessage(Color(Hex(success)));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("white") || args[1].equalsIgnoreCase("f")) {
                        certaincolorperm.replace("%color-name%", "white");
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {
                            try {
                                colorset.setString(1, "f");
                                success.replace("%color%", "&f");
                                player.sendMessage(Color(Hex(success)));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("bold") || args[1].equalsIgnoreCase("l")) {
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {
                            try {
                                PreparedStatement boldcheckps = plugin.DB.getConnection().prepareStatement("SELECT bold FROM chatcolor WHERE playerUUID=?");
                                boldcheckps.setString(1, player.getUniqueId().toString());
                                ResultSet boldcheckrs = boldcheckps.executeQuery();
                                int boldcheck = 0;
                                if (boldcheckrs.next()){
                                    boldcheck = boldcheckrs.getInt("bold");
                                }
                                if (boldcheck == 1){
                                    boldset.setInt(1, 0);
                                }else{
                                    boldset.setInt(1,0);
                                }
                                boldset.executeUpdate();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("italic") || args[1].equalsIgnoreCase("o")) {
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {
                            try {
                                PreparedStatement italiccheckps = plugin.DB.getConnection().prepareStatement("SELECT italic FROM chatcolor WHERE playerUUID=?");
                                italiccheckps.setString(1, player.getUniqueId().toString());
                                ResultSet italiccheckrs = italiccheckps.executeQuery();
                                int italiccheck = 0;
                                if (italiccheckrs.next()){
                                    italiccheck = italiccheckrs.getInt("italic");
                                }
                                if (italiccheck == 1){
                                    italicset.setInt(1, 0);
                                }else{
                                    italicset.setInt(1,0);
                                }
                                italicset.executeUpdate();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("underline") || args[1].equalsIgnoreCase("n")) {
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {
                            try {
                                PreparedStatement boldcheckps = plugin.DB.getConnection().prepareStatement("SELECT bold FROM chatcolor WHERE playerUUID=?");
                                boldcheckps.setString(1, player.getUniqueId().toString());
                                ResultSet boldcheckrs = boldcheckps.executeQuery();
                                int boldcheck = 0;
                                if (boldcheckrs.next()){
                                    boldcheck = boldcheckrs.getInt("bold");
                                }
                                if (boldcheck == 1){
                                    boldset.setInt(1, 0);
                                }else{
                                    boldset.setInt(1,0);
                                }
                                boldset.executeUpdate();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("strikethrough") || args[1].equalsIgnoreCase("m")) {
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {

                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("magic") || args[1].equalsIgnoreCase("k")) {
                        if (player.hasPermission(certaincolorperm) || player.hasPermission(allcolorperm) || player.hasPermission(everyperm)) {

                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }

                    } else if (args[1].equalsIgnoreCase("hex")) {
                        if (player.hasPermission(hexperm) || player.hasPermission(everyperm)){

                            Pattern HEX_PATTERN = Pattern.compile("&(#\\w{6})");
                            String hexChoice = args[1];
                            if (hexChoice.matches(HEX_PATTERN.pattern())) {
                                Matcher matcher = HEX_PATTERN.matcher(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', hexChoice));
                                StringBuffer buffer = new StringBuffer();
                                while (matcher.find()) {
                                    matcher.appendReplacement(buffer, net.md_5.bungee.api.ChatColor.of(matcher.group(1)).toString());
                                }
                                matcher.appendTail(buffer).toString();
                                try {
                                    colorset.setString(1, hexChoice);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }

                            }
                        }else{
                            player.sendMessage(Color(Hex(noperm)));
                        }
                    }
                    try {
                        colorset.executeUpdate();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }


                }



            }






        return true;
    }


    private String Color(String s){
        s = ChatColor.translateAlternateColorCodes('&', s);
        return s;
    }

    private static final Pattern HEX_PATTERN = Pattern.compile("&(#\\w{6})");

    public static String Hex(String message) {
        Matcher matcher = HEX_PATTERN.matcher(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&', message));
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(buffer, net.md_5.bungee.api.ChatColor.of(matcher.group(1)).toString());
        }

        return matcher.appendTail(buffer).toString();
    }

}