package com.pl.premier.zone.player;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "prem_stats")
public class Player {

    @Id
    @CsvBindByName(column = "Player")
    @Column(name = "Player", unique = true)
    private String name;

    @CsvBindByName(column = "Nation")
    private String nation;

    @CsvBindByName(column = "Pos")
    private String pos;

    @CsvBindByName(column = "Age")
    private Integer age;

    @CsvBindByName(column = "MP")
    private Integer mp;

    @CsvBindByName(column = "Starts")
    private Integer starts;

    @CsvBindByName(column = "Min")
    private Double min;

    @CsvBindByName(column = "Gls")
    private Double gls;

    @CsvBindByName(column = "Ast")
    private Double ast;

    @CsvBindByName(column = "PK")
    private Double pk;

    @CsvBindByName(column = "CrdY")
    private Double crdy;

    @CsvBindByName(column = "CrdR")
    private Double crdr;

    @CsvBindByName(column = "xG")
    private Double xg;

    @CsvBindByName(column = "xAG")
    private Double xag;

    @CsvBindByName(column = "Team")
    private String team;

    // Standard constructor
    public Player() {
    }

    // Constructor
    public Player(String name, String nation, String pos, Integer age, Integer mp, Integer starts, Double min, Double gls, Double ast, Double pk, Double crdy, Double crdr, Double xg, Double xag, String team) {
        this.name = name;
        this.nation = nation;
        this.pos = pos;
        this.age = age;
        this.mp = mp;
        this.starts = starts;
        this.min = min;
        this.gls = gls;
        this.ast = ast;
        this.pk = pk;
        this.crdy = crdy;
        this.crdr = crdr;
        this.xg = xg;
        this.xag = xag;
        this.team = team;
    }

    // Getters og Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNation() { return nation; }
    public void setNation(String nation) { this.nation = nation; }

    public String getPos() { return pos; }
    public void setPos(String pos) { this.pos = pos; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public Integer getMp() { return mp; }
    public void setMp(Integer mp) { this.mp = mp; }

    public Integer getStarts() { return starts; }
    public void setStarts(Integer starts) { this.starts = starts; }

    public Double getMin() { return min; }
    public void setMin(Double min) { this.min = min; }

    public Double getGls() { return gls; }
    public void setGls(Double gls) { this.gls = gls; }

    public Double getAst() { return ast; }
    public void setAst(Double ast) { this.ast = ast; }

    public Double getPk() { return pk; }
    public void setPk(Double pk) { this.pk = pk; }

    public Double getCrdy() { return crdy; }
    public void setCrdy(Double crdy) { this.crdy = crdy; }

    public Double getCrdr() { return crdr; }
    public void setCrdr(Double crdr) { this.crdr = crdr; }

    public Double getXg() { return xg; }
    public void setXg(Double xg) { this.xg = xg; }

    public Double getXag() { return xag; }
    public void setXag(Double xag) { this.xag = xag; }

    public String getTeam() { return team; }
    public void setTeam(String team) { this.team = team; }
}