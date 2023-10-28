# Conceitos importantes
- Data-[hora] **local**
  - ano-mes-dia-[hora] sem fuso horário
  - hora opcional
- Data-[hora] **global**
  - ano-mes-dia-[hora] com fuso horário
- duração
  - tempo decorrido entre duas data-horas

# Iso 8601
- padrão representar datas e horas em texto
- data hora local
  - 2022-07-21
  - 2022-07-21T14:52
  - 2022-07-21T14:52:09
  - 2022-07-21T14:52:09.4073
- data hora global
  - 2022-07-21T14:52:09z
  - 2022-07-21T14:52:09.254934z
  - 2022-07-21T14:52:09-03:00 (fuso horário diferente GNT -> horario londres -3)

# Principais tipos
- data hora local
  - LocalDate
  - LocalDateTime
- data hora global
  - Instant
- Duração
  - Durant
- outros
  - Zoneld
  - Chrono Unit

# DatetimeFormatter