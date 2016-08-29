-- [COLAB-953] add new auto increment keys
ALTER TABLE xcolab_TrackedVisit MODIFY id_ BIGINT(20) AUTO_INCREMENT;
ALTER TABLE xcolab_TrackedVisitor2User MODIFY id_ BIGINT(20) AUTO_INCREMENT;

-- [COLAB-1333] add new auto increment key
ALTER TABLE xcolab_LoginLog MODIFY pk BIGINT(20) AUTO_INCREMENT;

-- [COLAB-1347] Synchronize passwords to fix missed updates
update `members_Member`, `User_`
set `members_Member`.`hashedPassword` = `User_`.password_
where `members_Member`.`id_` = `User_`.userId;