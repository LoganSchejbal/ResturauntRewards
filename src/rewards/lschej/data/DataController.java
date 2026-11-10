package rewards.lschej.data;

import java.util.List;

public interface DataController {

    public static final Settings settings = new Settings();

    /**
     * Targeted Member
     */
    public void addTarget(String target);

    public String getTarget();

    public void clearTarget();

    /**
     * Member Data Handling
     */
    public void addMember(Member newMemeber);

    public Member getMember(String phoneNumber);

    /**
     * Rewards Handling
     */
    public void addReward(RewardItem reward);

    public List<RewardItem> getRewards();
}
