package com.daviddefco.codesamples.spring5.springmvcrest.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String position;
    private Integer number;
    private Integer experience;
    private Integer weight;
    private String height;

    public Player() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return this.position;
    }

    public Integer getNumber() {
        return this.number;
    }

    public Integer getExperience() {
        return this.experience;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public String getHeight() {
        return this.height;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Player)) return false;
        final Player other = (Player) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$position = this.getPosition();
        final Object other$position = other.getPosition();
        if (this$position == null ? other$position != null : !this$position.equals(other$position)) return false;
        final Object this$number = this.getNumber();
        final Object other$number = other.getNumber();
        if (this$number == null ? other$number != null : !this$number.equals(other$number)) return false;
        final Object this$experience = this.getExperience();
        final Object other$experience = other.getExperience();
        if (this$experience == null ? other$experience != null : !this$experience.equals(other$experience))
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
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $position = this.getPosition();
        result = result * PRIME + ($position == null ? 43 : $position.hashCode());
        final Object $number = this.getNumber();
        result = result * PRIME + ($number == null ? 43 : $number.hashCode());
        final Object $experience = this.getExperience();
        result = result * PRIME + ($experience == null ? 43 : $experience.hashCode());
        final Object $weight = this.getWeight();
        result = result * PRIME + ($weight == null ? 43 : $weight.hashCode());
        final Object $height = this.getHeight();
        result = result * PRIME + ($height == null ? 43 : $height.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Player;
    }

    public String toString() {
        return "Player(id=" + this.getId() + ", name=" + this.getName() + ", position=" + this.getPosition() + ", number=" + this.getNumber() + ", experience=" + this.getExperience() + ", weight=" + this.getWeight() + ", height=" + this.getHeight() + ")";
    }
}
