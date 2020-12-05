/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voting.mangement;

/**
 *
 * @author hassam
 */
public class candidates extends voters {
    String partyname,leader,headquater,party_sign;
  

    public candidates(String partyname, String leader, String headquater, String gender, String party_sign, int age) {
        this.partyname = partyname;
        this.leader = leader;
        this.headquater = headquater;
        this.gender = gender;
        this.party_sign = party_sign;
        this.age = age;
    }
    public candidates(){
        
    }

    public void setPartyname(String partyname) {
        this.partyname = partyname;
    }

    public void setParty_sign(String party_sign) {
        this.party_sign = party_sign;
    }
    
    public String getPartyname() {
        return partyname;
    }

    public String getLeader() {
        return leader;
    }

    public String getHeadquater() {
        return headquater;
    }

    @Override
    public String getGender() {
        return super.getGender(); //To change body of generated methods, choose Tools | Templates.
    }

    

    public String getParty_sign() {
        return party_sign;
    }

    @Override
    public int getAge() {
        return age;
    }
    
    
    
}
