import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class App {
    public static void main(String[] args) throws Exception {
        LocalDate nowLocalDate = LocalDate.now();
        LocalDateTime nowLocalDateTime = LocalDateTime.now();
        System.out.println(nowLocalDate);
        System.out.println(nowLocalDateTime);

        Instant nowGlobalDate = Instant.now();
        System.out.println(nowGlobalDate);

        LocalDate parseLocalDateIso = LocalDate.parse("2022-07-20");
        LocalDateTime parseLocalDateTimeIso = LocalDateTime.parse("2022-07-20T01:30:26");
        System.out.println(parseLocalDateIso);
        System.out.println(parseLocalDateTimeIso);

        Instant parseGlobalDateTimeIso = Instant.parse("2022-07-20T01:30:26z");
        Instant parseGlobalDateTimeMGIso = Instant.parse("2022-07-20T01:30:26-03:00");
        System.out.println(parseGlobalDateTimeIso);
        System.out.println(parseGlobalDateTimeMGIso);

        // texto customizado
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDate parseLocalDateBR = LocalDate.parse("20/07/2022", formatterDate);
        LocalDateTime parseLocalDatetTimeBR = LocalDateTime.parse("20/07/2022 01:30", formatterDateTime);
        System.out.println(parseLocalDateBR);
        System.out.println(parseLocalDatetTimeBR);

        // passando os valores separados
        LocalDate separateDate = LocalDate.of(2023, 10, 28);
        LocalDateTime separateDateTime = LocalDateTime.of(2023, 10, 28, 1, 30);
        System.out.println(separateDate);
        System.out.println(separateDateTime);

        // pasando para texto
        System.out.println(parseLocalDateIso.format(formatterDate));
        System.out.println(formatterDate.format(parseLocalDateIso));
        System.out.println(parseLocalDateTimeIso.format(formatterDate));
        System.out.println(parseLocalDateTimeIso.format(formatterDateTime));

        DateTimeFormatter formatterGlobalDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
            .withZone(ZoneId.systemDefault());
        System.out.println("Sem calcular time zone = " + parseGlobalDateTimeIso);
        System.out.println(formatterDateTime.withZone(ZoneId.systemDefault()).format(parseGlobalDateTimeIso));
        System.out.println(formatterGlobalDateTime.format(parseGlobalDateTimeIso));

        // para formato ISO (faz isso automaticamente tbm)
        DateTimeFormatter formaterLocalDateTimeIso = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter formaterGlobalDateTimeIso = DateTimeFormatter.ISO_INSTANT;

        System.out.println(parseLocalDateTimeIso.format(formaterLocalDateTimeIso));
        System.out.println(formaterGlobalDateTimeIso.format(parseGlobalDateTimeIso));

        // converter global -> local
        // pegar as zonas ZoneId.getAvailableZoneIds();
        LocalDate parseGlobalDateTimeToLocalDate = LocalDate.ofInstant(parseGlobalDateTimeIso, ZoneId.systemDefault());
        System.out.println("Global: " + parseGlobalDateTimeIso + " - Local: " + parseGlobalDateTimeToLocalDate);

        LocalDateTime parseGlobalDateTimeToLocalDateTime = LocalDateTime.ofInstant(parseGlobalDateTimeIso, ZoneId.systemDefault());
        System.out.println("Global: " + parseGlobalDateTimeIso + " - Local: " + parseGlobalDateTimeToLocalDateTime);

        // obter dados da data
        System.out.println("Dia " + parseLocalDateIso.getDayOfMonth());

        // calculos
        LocalDateTime pastWeekLocalDateTime = parseLocalDateTimeIso.minusDays(7);
        LocalDateTime nextWeekLocalDateTime = parseLocalDateTimeIso.plusDays(7);
        System.out.println("Subtração 7 dias " + pastWeekLocalDateTime);
        System.out.println("Adição 7 dias " + nextWeekLocalDateTime);

        Instant pastWeekGlobalDate = parseGlobalDateTimeIso.minus(7, ChronoUnit.DAYS);
        Instant nextWeekGlobalDate = parseGlobalDateTimeIso.plus(7, ChronoUnit.DAYS);
        System.out.println("Subtração global 7 dias " + pastWeekGlobalDate);
        System.out.println("Adição global 7 dias " + nextWeekGlobalDate);

        // calcular duração
        Duration durationBetween = Duration.between(pastWeekLocalDateTime, parseLocalDateTimeIso);
        // convertando localDate para localdatetime
        Duration durationBetweenLocalDate = Duration.between(pastWeekLocalDateTime, parseLocalDateIso.atStartOfDay());
        Duration durationBetweenGlobalDateTime = Duration.between(pastWeekGlobalDate, parseGlobalDateTimeIso);
        System.out.println(durationBetween.toDays());
        System.out.println(durationBetweenLocalDate.toDays());
        System.out.println(durationBetweenGlobalDateTime.toDays());
    }
}
