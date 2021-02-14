# JDA-Custom-Events

Add the files in your project


An exemple :
```java
public class Main extends CustomListeners {
  //YOU NEED THIS TO STORE THE INVITES
  public static Map<Guild, List<Invite>> invites = new HashMap<Guild, List<Invite>>();
  
  public static void main(String[] args) throws Exception {
    JDA jda = JDABuilder.createDefault("the little token").addEventListeners(new Main()).build();
  }
  
  @Override
	public void onGuildMemberJoinByInvit(GuildMemberJoinByInvitEvent event) {
		System.out.println(event.getInvite().getCode());
	}
}
```

If you have an error in the `CustomListeners.java` and the `GuildMemberJoinByInvitEvent.java` just replace the `Main` by your principal class and refresh the import.
