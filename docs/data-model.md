## DDL for Data Model
```sql

```CREATE TABLE IF NOT EXISTS `Game`
   (
       `game_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
       `title`   TEXT
   )
   CREATE TABLE IF NOT EXISTS `Preferences`
   (
       `Id`         INTEGER NOT NULL,
       `MouseDpi`   TEXT,
       `Resolution` TEXT,
       PRIMARY KEY (`Id`)
   )
   CREATE TABLE IF NOT EXISTS `ProPlayers`
   (
       `id`         INTEGER,
       `progame_id` INTEGER,
       `Proname`    TEXT,
       `Settings`   TEXT,
       PRIMARY KEY (`id`),
       FOREIGN KEY (`progame_id`) REFERENCES `Game` (`game_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
   )
   CREATE TABLE IF NOT EXISTS `ConversionFactory`
   (
       `id`         INTEGER NOT NULL,
       `game_1_id`  INTEGER NOT NULL,
       `game_2_id`  INTEGER NOT NULL,
       `conversion` TEXT,
       PRIMARY KEY (`id`),
       FOREIGN KEY (`game_1_id`) REFERENCES `Game` (`game_id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
       FOREIGN KEY (`game_2_id`) REFERENCES `Game` (`game_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
   )