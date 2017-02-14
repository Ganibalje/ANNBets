package com.ANNBets.parser;

import com.ANNBets.FileStatuses;
import com.ANNBets.entities.*;
import com.ANNBets.service.*;
import com.csvreader.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by siarhei_beliabniou on 19.1.17.
 */
@Component
public class Parser {

    @Autowired
    private LeagueService autowiredLeagueService;
    private static LeagueService leagueService;

    @Autowired
    private TeamService autowiredTeamService;
    private static TeamService teamService;

    @Autowired
    private RefereeService autowiredRefereeService;
    private static RefereeService refereeService;

    @Autowired
    private PlayedMatchService autowiredPlayedMatchService;
    private static PlayedMatchService playedMatchService;

    @Autowired
    private UsualStatsService autowiredUsualStatsService;
    private static UsualStatsService usualStatsService;

    @Autowired
    private AdditionalStatsService autowiredAdditionalStatsService;
    private static AdditionalStatsService additionalStatsService;

    @Autowired
    private StatsService autowiredStatsService;
    private static StatsService statsService;

    @Autowired
    private Bets1X2Service autowiredBets1X2Service;
    private static Bets1X2Service bets1X2Service;

    @Autowired
    private Bb1X2BetsService autowiredBb1X2BetsService;
    private static Bb1X2BetsService bb1X2BetsService;

    @Autowired
    private BbOUBetsService autowiredBbOUBetsService;
    private static BbOUBetsService bbOUBetsService;

    @Autowired
    private BbAHBetsService autowiredBbAHBetsService;
    private static BbAHBetsService bbAHBetsService;

    @Autowired
    private ClosingBetsService autowiredClosingBetsService;
    private static ClosingBetsService closingBetsService;

    @Autowired
    private BetsService autowiredBetsService;
    private static BetsService betsService;

    @Autowired
    private FileService autowiredFileService;
    private static FileService fileService;

    @PostConstruct
    public void initStaticService() {
        leagueService = this.autowiredLeagueService;
        teamService = this.autowiredTeamService;
        refereeService = this.autowiredRefereeService;
        playedMatchService = this.autowiredPlayedMatchService;
        usualStatsService = this.autowiredUsualStatsService;
        additionalStatsService = this.autowiredAdditionalStatsService;
        statsService = this.autowiredStatsService;
        bets1X2Service = this.autowiredBets1X2Service;
        bb1X2BetsService = this.autowiredBb1X2BetsService;
        bbOUBetsService = this.autowiredBbOUBetsService;
        bbAHBetsService = this.autowiredBbAHBetsService;
        closingBetsService = this.autowiredClosingBetsService;
        betsService = this.autowiredBetsService;
        fileService = this.autowiredFileService;
    }

    public static boolean doParsing(File file){
        file.setFileStatus(FileStatuses.parsing);
        fileService.updateFile(file);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        CsvReader reader = null;
        try{
            reader = new CsvReader(new InputStreamReader(new ByteArrayInputStream(file.getFileData())), ',');
            reader.readHeaders();
            boolean isLeagueSaved = false;
            League league = null;
            while (reader.readRecord()) {
                if (readString(reader, "Div") != null) {
                    if (!isLeagueSaved) {
                        String leagueName = reader.get("Div");
                        if (leagueService.isExistByName(leagueName)) {
                            league = leagueService.getLeagueByName(leagueName);
                            isLeagueSaved = true;
                        } else {
                            League tmpLeague = new League();
                            tmpLeague.setName(reader.get("Div"));
                            league = leagueService.getLeagueById(leagueService.addLeague(tmpLeague));
                            isLeagueSaved = true;
                        }
                    }
                    Team homeTeam = createOrLoadTeam(reader, reader.get("HomeTeam"), league);
                    Team awayTeam = createOrLoadTeam(reader, reader.get("AwayTeam"), league);
                    Date dateOfMatch = formatter.parse(readString(reader, "Date"));
                    if (!playedMatchService.isExist(homeTeam, awayTeam, dateOfMatch)) {
                        Referee referee = null;
                        String refereeName = readString(reader, "Referee");
                        if (refereeName != null) {
                            if (refereeService.isExistByName(refereeName))
                                referee = refereeService.getRefereeByName(refereeName);
                            else {
                                Referee tmpReferee = new Referee();
                                tmpReferee.setName(refereeName);
                                referee = refereeService.getRefereeById(refereeService.addReferee(tmpReferee));
                            }
                        }

                        UsualStats tmpUsualStats = new UsualStats();
                        tmpUsualStats.setFTHG(readInt(reader, "FTHG"));
                        tmpUsualStats.setFTAG(readInt(reader, "FTAG"));
                        tmpUsualStats.setFTR(readString(reader, "FTR"));
                        tmpUsualStats.setHTHG(readInt(reader, "HTHG"));
                        tmpUsualStats.setHTAG(readInt(reader, "HTAG"));
                        tmpUsualStats.setHTR(readString(reader, "HTR"));
                        UsualStats usualStats = usualStatsService.getUsualStatsById(usualStatsService.addUsualStats(tmpUsualStats));

                        AdditionalStats tmpAdditionalStats = new AdditionalStats();
                        tmpAdditionalStats.setHS(readInt(reader, "HS"));
                        tmpAdditionalStats.setAS(readInt(reader, "AS"));
                        tmpAdditionalStats.setHST(readInt(reader, "HST"));
                        tmpAdditionalStats.setAST(readInt(reader, "AST"));
                        tmpAdditionalStats.setHHW(readInt(reader, "HHW"));
                        tmpAdditionalStats.setAHW(readInt(reader, "AHW"));
                        tmpAdditionalStats.setHC(readInt(reader, "HC"));
                        tmpAdditionalStats.setAC(readInt(reader, "AC"));
                        tmpAdditionalStats.setHF(readInt(reader, "HF"));
                        tmpAdditionalStats.setAF(readInt(reader, "AF"));
                        tmpAdditionalStats.setHO(readInt(reader, "HO"));
                        tmpAdditionalStats.setAO(readInt(reader, "AO"));
                        tmpAdditionalStats.setHY(readInt(reader, "HY"));
                        tmpAdditionalStats.setAY(readInt(reader, "AY"));
                        tmpAdditionalStats.setHR(readInt(reader, "HR"));
                        tmpAdditionalStats.setAR(readInt(reader, "AR"));
                        tmpAdditionalStats.setHBP(readInt(reader, "HBP"));
                        tmpAdditionalStats.setABP(readInt(reader, "ABP"));
                        AdditionalStats additionalStats = null;
                        if (tmpAdditionalStats.isFilled())
                            additionalStats = additionalStatsService.getAdditionalStatsById(additionalStatsService.addAdditionalStats(tmpAdditionalStats));

                        Stats tmpStats = new Stats();
                        tmpStats.setUsualStats(usualStats);
                        tmpStats.setAdditionalStats(additionalStats);
                        Stats stats = statsService.getStatsById(statsService.addStats(tmpStats));

                        Bets1X2 tmpBets1X2 = new Bets1X2();
                        tmpBets1X2.setB365H(readFloat(reader, "B365H"));
                        tmpBets1X2.setB365D(readFloat(reader, "B365D"));
                        tmpBets1X2.setB365A(readFloat(reader, "B365A"));
                        tmpBets1X2.setBSH(readFloat(reader, "BSH"));
                        tmpBets1X2.setBSD(readFloat(reader, "BSD"));
                        tmpBets1X2.setBSA(readFloat(reader, "BSA"));
                        tmpBets1X2.setBWH(readFloat(reader, "BWH"));
                        tmpBets1X2.setBWD(readFloat(reader, "BWD"));
                        tmpBets1X2.setBWA(readFloat(reader, "BWA"));
                        tmpBets1X2.setGBH(readFloat(reader, "GBH"));
                        tmpBets1X2.setGBD(readFloat(reader, "GBD"));
                        tmpBets1X2.setGBA(readFloat(reader, "GBA"));
                        tmpBets1X2.setIWH(readFloat(reader, "IWH"));
                        tmpBets1X2.setIWD(readFloat(reader, "IWD"));
                        tmpBets1X2.setIWA(readFloat(reader, "IWA"));
                        tmpBets1X2.setLBH(readFloat(reader, "LBH"));
                        tmpBets1X2.setLBD(readFloat(reader, "LBD"));
                        tmpBets1X2.setLBA(readFloat(reader, "LBA"));
                        tmpBets1X2.setPSH(readFloat(reader, "PSH"));
                        tmpBets1X2.setPSD(readFloat(reader, "PSD"));
                        tmpBets1X2.setPSA(readFloat(reader, "PSA"));
                        tmpBets1X2.setSOH(readFloat(reader, "SOH"));
                        tmpBets1X2.setSOD(readFloat(reader, "SOD"));
                        tmpBets1X2.setSOA(readFloat(reader, "SOA"));
                        tmpBets1X2.setSBH(readFloat(reader, "SBH"));
                        tmpBets1X2.setSBD(readFloat(reader, "SBD"));
                        tmpBets1X2.setSBA(readFloat(reader, "SBA"));
                        tmpBets1X2.setSJH(readFloat(reader, "SJH"));
                        tmpBets1X2.setSJD(readFloat(reader, "SJD"));
                        tmpBets1X2.setSJA(readFloat(reader, "SJA"));
                        tmpBets1X2.setSYH(readFloat(reader, "SYH"));
                        tmpBets1X2.setSYD(readFloat(reader, "SYD"));
                        tmpBets1X2.setSYA(readFloat(reader, "SYA"));
                        tmpBets1X2.setVCH(readFloat(reader, "VCH"));
                        tmpBets1X2.setVCD(readFloat(reader, "VCD"));
                        tmpBets1X2.setVCA(readFloat(reader, "VCA"));
                        tmpBets1X2.setWHH(readFloat(reader, "WHH"));
                        tmpBets1X2.setWHD(readFloat(reader, "WHD"));
                        tmpBets1X2.setWHA(readFloat(reader, "WHA"));
                        Bets1X2 bets1X2 = null;
                        if (tmpBets1X2.isFilled())
                            bets1X2 = bets1X2Service.getBets1X2ById(bets1X2Service.addBets1X2(tmpBets1X2));

                        Bb1X2Bets tmpBb1X2Bets = new Bb1X2Bets();
                        tmpBb1X2Bets.setBbMxH(readFloat(reader, "BbMxH"));
                        tmpBb1X2Bets.setBbAvH(readFloat(reader, "BbAvH"));
                        tmpBb1X2Bets.setBbMxD(readFloat(reader, "BbMxD"));
                        tmpBb1X2Bets.setBbAvD(readFloat(reader, "BbAvD"));
                        tmpBb1X2Bets.setBbMxA(readFloat(reader, "BbMxA"));
                        tmpBb1X2Bets.setBbAvH(readFloat(reader, "BbAvA"));
                        Bb1X2Bets bb1X2Bets = null;
                        if (tmpBb1X2Bets.isFilled())
                            bb1X2Bets = bb1X2BetsService.getBb1X2BetsById(bb1X2BetsService.addBb1X2Bets(tmpBb1X2Bets));

                        BbOUBets tmpBbOUBets = new BbOUBets();
                        tmpBbOUBets.setBbMx_more_25(readFloat(reader, "BbMx>2.5"));
                        tmpBbOUBets.setBbAv_more_25(readFloat(reader, "BbAv>2.5"));
                        tmpBbOUBets.setBbMx_less_25(readFloat(reader, "BbMx<2.5"));
                        tmpBbOUBets.setBbAv_less_25(readFloat(reader, "BbAv<2.5"));
                        tmpBbOUBets.setGB_more_25(readFloat(reader, "GB>2.5"));
                        tmpBbOUBets.setGB_less_25(readFloat(reader, "GB<2.5"));
                        tmpBbOUBets.setB365_more_25(readFloat(reader, "B365>2.5"));
                        tmpBbOUBets.setB365_less_25(readFloat(reader, "B365<2.5"));
                        BbOUBets bbOUBets = null;
                        if (tmpBbOUBets.isFilled())
                            bbOUBets = bbOUBetsService.getBbOUBetsById(bbOUBetsService.addBbOUBets(tmpBbOUBets));

                        BbAHBets tmpBbAHBets = new BbAHBets();
                        tmpBbAHBets.setBbAHh(readFloat(reader, "BbAHh"));
                        tmpBbAHBets.setBbMxAHH(readFloat(reader, "BbMxAHH"));
                        tmpBbAHBets.setBbAvAHH(readFloat(reader, "BbAvAHH"));
                        tmpBbAHBets.setBbMxAHA(readFloat(reader, "BbMxAHA"));
                        tmpBbAHBets.setBbAvAHA(readFloat(reader, "BbAvAHA"));
                        tmpBbAHBets.setGBAHH(readFloat(reader, "GBAHH"));
                        tmpBbAHBets.setGBAHA(readFloat(reader, "GBAHA"));
                        tmpBbAHBets.setGBAH(readFloat(reader, "GBAH"));
                        tmpBbAHBets.setLBAHH(readFloat(reader, "LBAHH"));
                        tmpBbAHBets.setLBAHA(readFloat(reader, "LBAHA"));
                        tmpBbAHBets.setLBAH(readFloat(reader, "LBAH"));
                        tmpBbAHBets.setB365AHH(readFloat(reader, "B365AHH"));
                        tmpBbAHBets.setB365AHA(readFloat(reader, "B365AHA"));
                        tmpBbAHBets.setB365AH(readFloat(reader, "B365AH"));
                        BbAHBets bbAHBets = null;
                        if (tmpBbAHBets.isFilled())
                            bbAHBets = bbAHBetsService.getBbAHBetsById(bbAHBetsService.addBbAHBets(tmpBbAHBets));

                        ClosingBets tmpClosingBets = new ClosingBets();
                        tmpClosingBets.setPSCH(readFloat(reader, "PSCH"));
                        tmpClosingBets.setPSCD(readFloat(reader, "PSCD"));
                        tmpClosingBets.setPSCA(readFloat(reader, "PSCA"));
                        ClosingBets closingBets = null;
                        if (tmpClosingBets.isFilled())
                            closingBets = closingBetsService.getClosingBetsById(closingBetsService.addClosingBets(tmpClosingBets));

                        Bets tmpBets = new Bets();
                        tmpBets.setBets1X2(bets1X2);
                        tmpBets.setBb1X2Bets(bb1X2Bets);
                        tmpBets.setBbOUBets(bbOUBets);
                        tmpBets.setBbAHBets(bbAHBets);
                        tmpBets.setClosingBets(closingBets);
                        Bets bets = null;
                        if (tmpBets.isFilled())
                            bets = betsService.getBetsById(betsService.addBets(tmpBets));


                        PlayedMatch playedMatch = new PlayedMatch();
                        playedMatch.setDate(dateOfMatch);
                        playedMatch.setHomeTeam(homeTeam);
                        playedMatch.setAwayTeam(awayTeam);
                        playedMatch.setStats(stats);
                        playedMatch.setBets(bets);
                        playedMatch.setReferee(referee);
                        playedMatchService.addMatch(playedMatch);

                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            file.setFileStatus(FileStatuses.error);
            fileService.updateFile(file);
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
            file.setFileStatus(FileStatuses.error);
            fileService.updateFile(file);
        }
        file.setFileStatus(FileStatuses.success);
        fileService.updateFile(file);
        return true;
    }

    private static Team createOrLoadTeam(CsvReader reader, String name, League league){
        Team team;
        if(teamService.isExistByName(name))
            team = teamService.getTeamByName(name);
        else {
            Team tmpTeam = new Team();
            tmpTeam.setName(name);
            tmpTeam.setLeague(league);
            team = teamService.getTeamById(teamService.addTeam(tmpTeam));
        }
        return team;
    }

    private static Integer readInt(CsvReader reader, String columnName) throws IOException {
        String tmp = reader.get(columnName);
        return tmp == "" ? null : Integer.valueOf(tmp);
    }

    private static Float readFloat(CsvReader reader, String columnName) throws IOException {
        String tmp = reader.get(columnName);
        return tmp == "" ? null : Float.valueOf(tmp);
    }

    private static String readString(CsvReader reader, String columnName) throws IOException {
        String tmp = reader.get(columnName);
        return tmp == "" ? null : tmp;
    }

}
