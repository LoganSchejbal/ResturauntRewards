package rewards.lschej.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHandler implements DataController {

    private String target;
    private final Map<String, Member> members = new HashMap<>();
    private final List<RewardItem> rewards = new ArrayList<>();

    public DataHandler() {
        target = "";
    }

    @Override
    public void addTarget(String target) {
        this.target = target;
    }

    @Override
    public String getTarget() {
        return target;
    }

    @Override
    public void clearTarget() {
        target = "";
    }

    @Override
    public void addMember(Member newMember) {
        members.put(newMember.getPhoneNumber(), newMember);
    }

    @Override
    public Member getMember(String phoneNumber) {
        return members.get(phoneNumber);
    }

    @Override
    public void addReward(RewardItem reward) {
        rewards.add(reward);
    }

    @Override
    public List<RewardItem> getRewards() {
        return rewards;
    }
}
