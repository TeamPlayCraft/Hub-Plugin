package me.DJBiokinetix;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Hub extends JavaPlugin implements Listener{

	String DiegoRank = (ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Dueño" + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " " + "diegoo000" + ChatColor.DARK_GRAY + "»" + " " + ChatColor.GRAY);
	String Axep_Rank = (ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Dueño" + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " " + "Axep_" + ChatColor.DARK_GRAY + "»" + " " + ChatColor.GRAY);
	String DJRank = (ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Dueño" + ChatColor.DARK_GRAY + "]" + ChatColor.RED + " " + "DJBiokinetix" + ChatColor.DARK_GRAY + "»" + " " + ChatColor.GRAY);
	String prefix = (ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Hub" + ChatColor.DARK_GRAY + "]" + " ");
	String msgkick = (ChatColor.GRAY + "¡Has sido echado mientras te conectabas al servidor!" + " ");
	String msgnormal = (ChatColor.GRAY + "Razones:" + ChatColor.RED + " " + "¡No eres bienvenido en este servidor!");
	String agresivemsg = (ChatColor.GRAY + " Razones:" + ChatColor.RED + " " + "Vete a la verga pendejo de mierda!");
	
	final HashMap<Long, Long> Timer = new HashMap<Long, Long>();
	public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
	
	@Override
	public void onEnable(){
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(this, this);
    }
	
	@Override
	public void onDisable(){
		saveDefaultConfig();
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	  Player jugador = (Player)sender;
	  
      int cdt = Integer.parseInt(getConfig().getString("Time"));
      String launch = getConfig().getString("Firework message");
      String notallowed = getConfig().getString("No permission");
      String wait = getConfig().getString("Wait message");

	  String leave = getConfig().getString("S Fake").replaceAll("&", "§").replaceAll("%user%", jugador.getPlayer().getName());
	  String entry = getConfig().getString("E Fake").replaceAll("&", "§").replaceAll("%user%", jugador.getPlayer().getName());
	  	  
	  	  if(cmd.getName().equalsIgnoreCase("hub")){
	  		if (args.length == 0) {
	  		  jugador.sendMessage(ChatColor.DARK_GRAY + "====== [" + ChatColor.GOLD + "Hub" + ChatColor.DARK_GRAY + "] ======");
	  		  jugador.sendMessage(ChatColor.GRAY + "Plugin by: " + ChatColor.RED + "DJBiokinetix");
	  		  jugador.sendMessage(ChatColor.GRAY + "Version: " + ChatColor.AQUA + "4.0");
	  		  jugador.sendMessage(ChatColor.GRAY + "For more info:" + ChatColor.RED + " " + "/hub help");
	  		  jugador.sendMessage(ChatColor.DARK_GRAY + "==================");
	  		} else if (args.length == 1) {
		        if (args[0].equalsIgnoreCase("reload")) {
		        	if(jugador.hasPermission("hub.reload")){
		        		saveDefaultConfig();
		        		reloadConfig();
		        		jugador.sendMessage(ChatColor.GREEN + "Configuration reloaded");
		        	}
		         } else if (args.length == 1){
		    		  if(args[0].equalsIgnoreCase("music")){
		    	  		  jugador.sendMessage(ChatColor.DARK_GRAY + "======================= [" + ChatColor.GOLD + "Music" + ChatColor.DARK_GRAY + "] =======================");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub 13 - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "13");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub cat - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "cat");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub blocks - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "blocks");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub chirp - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "chirp");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub far - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "far");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub mall - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "mall");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub mellohi - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "mellohi");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub stal - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "stal");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub strad - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "strad");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub ward - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "ward");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub 11 - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "11");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub wait - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "wait");
		    	  		  jugador.sendMessage(ChatColor.DARK_GRAY + "=====================================================");
		    		  } else if (args.length == 1) {
		    	    		if (args[0].equalsIgnoreCase("help")) {
		    	    	    	  jugador.sendMessage(ChatColor.DARK_GRAY + "=========================================");
		    	    	          jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.GRAY + "/fw - Launch fireworks!");
		    	    	          jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.GRAY + "/fw help");
		    	    	          jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.GRAY + "/fake - Fake message 'leave'");
		    	    	          jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.GRAY + "/entry - Fake message 'join'");
		    	    	          jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.GRAY + "/hub - Hub version and author!");
		    	    	          jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.GRAY + "/hub reload - Reload the config files!");
		    	    	          jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.GRAY + "/hub music - menu of the disco mode...");
		    	    	          jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.GRAY + "/hub help - display this menu");
		    	    	          jugador.sendMessage(ChatColor.DARK_GRAY + "=========================================");
		    	   		 } else if (args.length == 1) {
		    	   			 if(args[0].equalsIgnoreCase("13")){
		    	   				if(jugador.hasPermission("13.hub")){
		    	   			      jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2256);
		    	   			      jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - 13");
		    	   				 } 
		    	   			 	} else if (args.length == 1) {
		    	   			 		if(args[0].equalsIgnoreCase("cat")){
		    	   			 			if(jugador.hasPermission("cat.hub")){
		    	   			 		      jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2257);
		    	   			 		      jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Cat");
		    	   			 			}
		    	   			 		} else if (args.length == 1) {
		    	   			 			if(args[0].equalsIgnoreCase("blocks")){
		    	   			 				if(jugador.hasPermission("blocks.hub")){
		    	   			 			      jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2258);
		    	   			 			      jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Blocks");
		    	   			 				}	 
		    	   			 			} else if (args.length == 1) {
		    	   			 				if(args[0].equalsIgnoreCase("chirp")){
		    	   			 					if(jugador.hasPermission("chirp.hub")){
		    	   			 				      jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2259);
		    	   			 				      jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Chirp");
		    	   			 					} 
		    	   			 				} else if (args.length == 1) {
		    	   			 					if(args[0].equalsIgnoreCase("far")){
		    	   			 						if(jugador.hasPermission("far.hub")){
		    	   			 					      jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2260);
		    	   			 					      jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Far");
		    	   			 						} 
		    	   			 					} else if (args.length == 1) {
		    	   			 						if(args[0].equalsIgnoreCase("mall")){
		    	   			 							if(jugador.hasPermission("mall.hub")){
		    	   			 						      jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2261);
		    	   			 						      jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Mall");
		    	   			 							} 
		    	   			 						} else if (args.length == 1) {
		    	   			 							if(args[0].equalsIgnoreCase("mellohi")){
		    	   			 								if(jugador.hasPermission("mellohi.hub")){
		    	   			 							      jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2262);
		    	   			 							      jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Mellohi");
		    	   			 								} 
		    	   			 							} else if (args.length == 1) {
		    	   			 								if(args[0].equalsIgnoreCase("stal")){
		    	   			 									if(jugador.hasPermission("stal.hub")){
		    	   			 								      jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2263);
		    	   			 								      jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Stal");
		    	   			 									} 
		    	   			 								} else if (args.length == 1) {
		    	   			 									if(args[0].equalsIgnoreCase("strad")){
		    	   			 										if(jugador.hasPermission("stard.hub")){
		    	   			 									      jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2264);
		    	   			 									      jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Strad");
		    	   			 										} 
		    	   			 									} else if (args.length == 1) {
		    	   			 										if(args[0].equalsIgnoreCase("ward")){
		    	   			 											if(jugador.hasPermission("ward.hub")){
		    	   			 										      jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2265);
		    	   			 										      jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Ward");
		    	   			 											}
		    	   			 										} else if (args.length == 1) {
		    	   			 											if(args[0].equalsIgnoreCase("11")){
		    	   			 												if(jugador.hasPermission("11.hub")){
		    	   			 											      jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2266);
		    	   			 											      jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - 11");
		    	   			 												} 
		    	   			 											} else if (args.length == 1) {
		    	   			 												if(args[0].equalsIgnoreCase("wait")){
		    	   			 													if(jugador.hasPermission("wait.hub")){
		    	   			 												      jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2267);
		    	   			 												      jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Wait");
		    	   			 													}
		    	   			 												}
		    	   			 											}
		    	   			 										}
		    	   			 									}
		    	   			 								}
		    	   			 							}
		    	   			 						}
		    	   			 					}
		    	   			 				}
		    	   			 			}
		    	   			 		} 
		    	   			 	}
		    	   		 	}
		    	   		 }
		    		  }
		         }
	  		}

	  	  if(cmd.getName().equalsIgnoreCase("fake")){
			  if(jugador.getPlayer().hasPermission("fake.hub")){
			  jugador.getServer().broadcastMessage(leave);
			  }}
	  	   	  
	  	  if(cmd.getName().equalsIgnoreCase("entry")){
			  if(jugador.getPlayer().hasPermission("fake.hub")){
			  jugador.getServer().broadcastMessage(entry);
			  FireworkTypes.shootFireworkRandom(jugador);
			  }}
	  	
	  	  if(cmd.getName().equalsIgnoreCase("rconfig")){
			  if(jugador.getPlayer().hasPermission("hub.reload")){
			  saveDefaultConfig();
			  reloadConfig();
			  jugador.sendMessage(ChatColor.GREEN + "Configuration reloaded!");
			  }}

	      if ((cmd.getName().equalsIgnoreCase("fw")) ||	(cmd.getName().equalsIgnoreCase("firework"))){
	    	      if (args.length == 0) {
	    	        if (jugador.hasPermission("firework.hub")) {
	    	          if (jugador.hasPermission("firework.admin")) {
	    	        	  FireworkTypes.shootFireworkRandom(jugador);
	    	            jugador.sendMessage(formatVariables(launch, jugador));
	    	          } else {
	    	            int cooldownTime = cdt;
	    	            if (this.cooldowns.containsKey(sender.getName())) {
	    	              long secondsLeft = ((Long)this.cooldowns.get(sender.getName())).longValue() / 1000L + cooldownTime - System.currentTimeMillis() / 1000L;
	    	              if (secondsLeft > 0L) {
	    	                sender.sendMessage(formatVariables(wait, jugador));
	    	                return true;
	    	              }
	    	            } this.cooldowns.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
	    	            FireworkTypes.shootFireworkRandom(jugador);
	    	            jugador.sendMessage(formatVariables(launch, jugador));
	    	          }
	    	        } else {
	    	          jugador.sendMessage(formatVariables(notallowed, jugador));
	    	        }
		    	  }
	    	    }
	    	    return false;
	    	  }
	 
	  @SuppressWarnings("deprecation")
	  @EventHandler
	    public void Join(PlayerJoinEvent e){
	      if (e.getPlayer().hasPermission("join.hub")){
	    	  if(e.getPlayer().getName().contains("Isaacsaso")){
	  			Player p = e.getPlayer();
	  			p.kickPlayer(prefix + msgkick + msgnormal);
	  		} else if(e.getPlayer().getName().contains("X_Jacks_X")){
	  			Player p = e.getPlayer();
	  			p.kickPlayer(prefix + msgkick + msgnormal);
	  		} else if(e.getPlayer().getName().contains("Drezzzlek")){
	  			Player p = e.getPlayer();
	  			p.kickPlayer(prefix + msgkick + msgnormal);
	  		} else if(e.getPlayer().getName().contains("PeacefulMen")){
	  			Player p = e.getPlayer();
	  			p.kickPlayer(prefix + msgkick + agresivemsg);
	  		} else if(e.getPlayer().getName().contains("SkilledShadows")){
	  			Player p = e.getPlayer();
	  			p.kickPlayer(prefix + msgkick + agresivemsg);
	  		} else if(e.getPlayer().getName().contains("AkatsukiPro")){
	  			Player p = e.getPlayer();
	  			p.kickPlayer(prefix + msgkick + agresivemsg);
	  		} else if(e.getPlayer().getName().contains("Notch")){
	  			Player notch = e.getPlayer();
	  	    	notch.playEffect(notch.getLocation(), Effect.RECORD_PLAY, 2259);
	  	    	notch.getPlayer().getServer().broadcastMessage("");
	  	    	notch.getPlayer().getServer().broadcastMessage(ChatColor.YELLOW + "████████");
	  	    	notch.getPlayer().getServer().broadcastMessage(ChatColor.YELLOW + "████████");
	  	    	notch.getPlayer().getServer().broadcastMessage(ChatColor.YELLOW + "█" + ChatColor.BLACK + "█" + ChatColor.YELLOW + "████" + ChatColor.BLACK + "█" + ChatColor.YELLOW + "█");
	  	    	notch.getPlayer().getServer().broadcastMessage(ChatColor.YELLOW + "████████");
	  	    	notch.getPlayer().getServer().broadcastMessage(ChatColor.YELLOW + "██" + ChatColor.BLACK + "████" + ChatColor.YELLOW + "██");
	  	    	notch.getPlayer().getServer().broadcastMessage(ChatColor.YELLOW + "█" + ChatColor.BLACK + "█" + ChatColor.WHITE + "████" + ChatColor.BLACK + "█" + ChatColor.YELLOW + "█");
	  	    	notch.getPlayer().getServer().broadcastMessage(ChatColor.YELLOW + "█" + ChatColor.BLACK + "██████" + ChatColor.YELLOW + "█");
	  	    	notch.getPlayer().getServer().broadcastMessage(ChatColor.YELLOW + "█" + ChatColor.BLACK + "██████" + ChatColor.YELLOW + "█");
	  	    	notch.getPlayer().getServer().broadcastMessage("");
	  	    	notch.getPlayer().getServer().broadcastMessage(ChatColor.YELLOW + "Notch joined the game!");
	  	  		notch.setDisplayName(ChatColor.RED + "Mojang team:" + " " + ChatColor.RESET + "<" + ChatColor.YELLOW + "Notch" + ChatColor.RESET + ">");
	  		} else if(e.getPlayer().getName().contains("Herobrine")){
	  			Player hero = e.getPlayer();
	  	  		hero.setDisplayName(ChatColor.RESET + "<Herobrine>");
	  	    	hero.getWorld().strikeLightningEffect(hero.getLocation());
	  	    	hero.getWorld().setStorm(true);
	  	    	hero.getWorld().setTime(16000);
	  	    	hero.playEffect(hero.getLocation(), Effect.RECORD_PLAY, 2256);
	  	    	hero.getPlayer().getServer().broadcastMessage(ChatColor.YELLOW + "Herobrine joined the game!");
	  		} else {
	        e.setJoinMessage(getConfig().getString("Join").replaceAll("&", "§").replaceAll("%user%", e.getPlayer().getName()));
	        FireworkTypes.shootFireworkRandom(e.getPlayer());
	        return;
	      	}
	     }
	      e.setJoinMessage(null);
	    }
  
  
	  @EventHandler
	  public void Leave(PlayerQuitEvent e){
		Player player = e.getPlayer();
		if (player.hasPermission("leave.hub")){
			if (e.getPlayer().getName().contains("Herobrine")){
	    		player.getServer().broadcastMessage(ChatColor.YELLOW + "Herobrine left the game!");
	    		player.getWorld().setStorm(false);
	    		player.getWorld().setTime(0);
	    		player.getWorld().strikeLightningEffect(player.getLocation());
	    		player.getServer().broadcastMessage(ChatColor.WHITE + "<Herobrine>" + " " + ChatColor.RED + "Jajajajajajaja! Herobrine is back!....");
	    	} else if (e.getPlayer().getName().contains("Notch")){
	    		player.getWorld().strikeLightningEffect(player.getLocation());
				player.getWorld().setStorm(false);
				player.getWorld().setTime(0);
	    		player.getServer().broadcastMessage(ChatColor.YELLOW + "Notch left the game!");
	    		player.getServer().broadcastMessage(ChatColor.RED + "Thanks for use Minecraft game of Mojang team!");
	    	} else {
		 e.setQuitMessage(getConfig().getString("Leave").replaceAll("&", "§").replaceAll("%user%", e.getPlayer().getName()));
		 return;
			}
		}
		e.setQuitMessage(null);
	  }
	  
  @EventHandler
  public void Kick(PlayerKickEvent e){
    e.setLeaveMessage(null);
  }

  public String formatVariables(String string, Player player){
	    int cdt = Integer.parseInt(getConfig().getString("Time"));
	    return ChatColor.translateAlternateColorCodes("&".charAt(0), string).replace("%time", String.valueOf(cdt));
	  }
}
