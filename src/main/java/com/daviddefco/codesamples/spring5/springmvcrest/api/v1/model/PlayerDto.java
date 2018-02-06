package com.daviddefco.codesamples.spring5.springmvcrest.api.v1.model;

public class PlayerDto {
    private String name;
    private Integer jerseyNumber;
    private String positionPlayed;
    private Integer priorExperience;
    private Integer weight;
    private String height;

    public PlayerDto() {
    }

    public String getName() {
        return this.name;
    }

    public Integer getJerseyNumber() {
        return this.jerseyNumber;
    }

    public String getPositionPlayed() {
        return this.positionPlayed;
    }

    public Integer getPriorExperience() {
        return this.priorExperience;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public String getHeight() {
        return this.height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public void setPositionPlayed(String positionPlayed) {
        this.positionPlayed = positionPlayed;
    }

    public void setPriorExperience(Integer priorExperience) {
        this.priorExperience = priorExperience;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PlayerDto)) return false;
        final PlayerDto other = (PlayerDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$jerseyNumber = this.getJerseyNumber();
        final Object other$jerseyNumber = other.getJerseyNumber();
        if (this$jerseyNumber == null ? other$jerseyNumber != null : !this$jerseyNumber.equals(other$jerseyNumber))
            return false;
        final Object this$positionPlayed = this.getPositionPlayed();
        final Object other$positionPlayed = other.getPositionPlayed();
        if (this$positionPlayed == null ? other$positionPlayed != null : !this$positionPlayed.equals(other$positionPlayed))
            return false;
        final Object this$priorExperience = this.getPriorExperience();
        final Object other$priorExperience = other.getPriorExperience();
        if (this$priorExperience == null ? other$priorExperience != null : !this$priorExperience.equals(other$priorExperience))
            return false;
        final Object this$weight = this.getWeight();
        final Object other$weight = other.getWeight();
        if (this$weight == null ? other$weight != null : !this$weight.equals(other$weight)) return false;
        final Object this$height = this.getHeight();
        final Object other$height = other.getHeight();
        if (this$height == null ? other$height != null : !this$height.equals(other$height)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $jerseyNumber = this.getJerseyNumber();
        result = result * PRIME + ($jerseyNumber == null ? 43 : $jerseyNumber.hashCode());
        final Object $positionPlayed = this.getPositionPlayed();
        result = result * PRIME + ($positionPlayed == null ? 43 : $positionPlayed.hashCode());
        final Object $priorExperience = this.getPriorExperience();
        result = result * PRIME + ($priorExperience == null ? 43 : $priorExperience.hashCode());
        final Object $weight = this.getWeight();
        result = result * PRIME + ($weight == null ? 43 : $weight.hashCode());
        final Object $height = this.getHeight();
        result = result * PRIME + ($height == null ? 43 : $height.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof PlayerDto;
    }

    public String toString() {
        return "PlayerDto(name=" + this.getName() + ", jerseyNumber=" + this.getJerseyNumber() + ", positionPlayed=" + this.getPositionPlayed() + ", priorExperience=" + this.getPriorExperience() + ", weight=" + this.getWeight() + ", height=" + this.getHeight() + ")";
    }
}
