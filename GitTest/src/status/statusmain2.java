package status;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.ResultSet;
import java.util.Scanner;

import login.level;

public class statusmain2 {

	public static void main(String[] args) throws InterruptedException {

		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		boolean isStart = false;
		int row = 0;
		boolean isSearch = false;
		level lv1 = new level(null, row, row, null);
		lv1.setName("test");
		lv1.setLv(1);
		lv1.setHp(20);
		lv1.setCon("좋음");
		Scanner sc = new Scanner(System.in);
		statusController controller = new statusController();
		statusDTO dto = new statusDTO();
		String art2 = """

				             .##%,                                            #%###%
				            #(#(#%/                                        %##//#####%
				           (//#((#%%                                    %#(///(/###//#
				          *(((###(##%%%%%%#*(##(##((##(/            (%#########(#####(
				          (###(##(#(#((##############################################(
				          #(######((#(#(####################(#(#((###(#########(#####(
				          (#####(#############################((/*(##(##########(#####
				          (##(#(###(#(#(###(#####(#(#(##(######(((/ (#(#((########((#(
				          ((##/##*(#############(##,/ *(##########(/ /################
				          (#(/((/&((###########(*%@&   **(##########/ /(#######(######
				           #(#####(#((########((((((((/#/*.((######((  (##############
				           *##(((%@@@@@@@@%(#######(#(###(###(#(###(#   #######(######
				           ###%@@@*/%%((&@@@@%#######################* (#(%%%%###(#(##
				          /@@@@@@@@@@@@@@#@@@@@%###(#(#####(###(###(#*  (#   %%##(##%%
				           &@@@@@@@@@@@@@@@@@@@@@@%#(######(#(#(#####*  %     %###(%%%
				            @@@@@@@@@@@@@@@@@@@@@@@@@@@&%######(###(/*         %##%%(/
				             @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#####(//         ,#%
				             &@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%##(//(         %
				            &%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&#((//
				           &@&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&((//
				          %@#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%(//#
				          @&@@@@@@@@@@@@@@@@@@@@@@@@@&%@@@@@@@@@@@@&(//*
				         &@%@@@@@@@@@@@@@@@@@@@@@@@@@#@@@@@@@@@@%@@@(//*
				         @&#@@@@@@@@@@@@@@@@@@@@@@@&&@@@@@@@@@@@(@@&#///
				         @&%@@@@@@@@@@@@@@@@@@@@@@@@(@@@@@@@@@@@(@%%////
				         &@&&@@@@@@@@@@@@@@@@@@@@@@@(@@@@@@@@@@/@%&%(//////*#
				          @@/@@@@@@@@@@@@@@@@@@@@@@@(@@@@@@@@@@@&%&&%//////////*
				            .@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%@@@@&%&%&%%%(////////
				            @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&%&&&&%&(/////
				           &@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&%%%%////
				           @@@@@@@@@@@  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%&///
				          /@@@@@@@@@&        ,@@@@@@@&@@@@@@@@@@@@@@@@@@@@@@@@&%#//,
				          #@@@@@@@@#         ,@@@@@@@    .#@@@@@@@@@@@*((/@@@@@@&//,
				          #@@@@@@@@          ,@@@@@@(         &%&%&%%      @@@@@@@&
				""";

		String art = """
				                                                               .=+*#*:
				                                                        .=+*#@%@#+:
				                                                   :=*%%%##*#+:
				                                               .=*%#**+++#+:
				                                            :+##*+++==*+:
				                                        .+**++++++==+=
				                                     :=**++++++===++
				                      ㅁ             +#+++++++=====*.
				                                 +#+++++++=====++
				                               :#+++++++======+=
				                             :++++++++=======+=                                             .====++*++===:.
				                           .*+++++++++=======#                                     .:=++*%%%#############%%%@@%*:
				                           %:++++++++++======*=.                             :==+*#*++++++++++++++++***====:.
				                           #:++++++++++++++++**+                        .=+**+++++++++++++++====**=:
				                          :*=++++++++====++=:                       =+**+==+++++++++=========*=:
				                          =+=+++++======*                        =**====++++++++=========:++:
				                          +=+++++=====+=                        @===+++++++++==========:++.
				                          #=+++++=====*.                      .%:=++++++++++==========:#.
				                          #=++++++++=++##                    =#:++++++++++++=========:#
				                          #+++++++++#+:              =+*####%*=++++++++++++++++=======+
				                         .#++++++++#.            :+##****+*#==++++++++++++======+****+%
				                         .*++++++*#           :+#******+*#+=+++++++++======+++==:.
				                         +*+++++*+         .+#******++*#*=+++++++++======#++:
				                         #+*++++*   ..:==+#*******++*#+==+++++++++=====*#+#@*
				                        .#****+*#####**********+++#*+=+++++++++++++===#++++*#
				                        %+*+++##************+++***=++++++++++++++++++=*++++**#
				                       =***+*#******+++++++++**+++++++++++++++++++=++++%*++**:=
				                      .#+*+*****+++++++++****+++++++++=+==********#****++++*+.#
				                     *%+******++++++*+***=++++++=====+*#**++++++++++++++++*=  #
				                    @+****+++++++++***+=*##**++*###***=++++++++++++++++++*.   #:
				                   #+***+++++++++++++=+++++*#**+++===++++++++**++*+++++=.    .*.
				                  :##**++++++++++++++++++++====+++++++++*=:.   ..             #
				                  %:#+++++++++++++++=++++++++++++++++++:                      #
				                 =@%#+++++++++++++++##**#+=+++++++++++                        *=
				                *##=*+++++++++++++*%.  :=**=++++++++*                :      .. =+
				               #*++*+=+++++++++++*%:@%=@@:@=++++++++:               =+*:  ..    #=
				               =:+=====++++++++++##:=*@+ **=+++++++.            .... #*+=+==**+@*@+
				               #  =+++++++++++++*+*#**+*#+++++++=.           ..... =+=      #%@%%+:
				               .*    .....:::::::::::====++==:.             ....===
				                 *=  =::=:                                 .::*=
				                   *+                                     :*++
				                    %#%*:::                               =.*
				                    @*#%* .==*#======::.                   =.
				                    +#**+=::.         .:::=:=++=         ..+
				                                                == ..    . +
				                                                 .+. .  . .+
				                                                   ==    =@:
				                                                    =#%+@%#@.
				                                                   .*###%@##
				                                                    .=:+*:

				""";

		String art6 = """
							                                                                                                      &
				                                                                ....@
				                                                               /.***,...&
				              @                                                @.**(*((*...@
				               & ,/                                            %.*((/****((....
				                 &../.                                          ,*/**(*****(/(,,&
				                    ,////                                     @.******&******/(/.,&
				                    (,,///,.                                 ,..****************(/.,/
				                      ,,////(*                              /..********************(..
				                       &,/((///                            *,,***********************(.#
				                        .,/&(#((@                        .,,*********************//////.%
				                          .(((##((                   &,,********************,,,/////////*,
				                           .&. ,,,*************#/*****************,,,*****//,,,,,,///////*.
				                         ( ,,,,,******************/&/(((*********,/ **,,////,,,,,,,*///////.
				                         ,,,,,,,******#  %@*********/@    &/*****%      ,,//,,.( *.,,//////*.
				                       # (,,,,,*****&/   %((&********/*       %**.        (,.@      .,./////,(
				                      %#%&,,,,,,***%/*%%%%%%%*********//                    #        (,,/////.@
				                     .#* #,,,,,,*****@&#/ &&**********///                              (,,////,
				                   &,,,,*          ********************//@                              @,,////*
				                   @     ,   .@#%             *********///                               *,,///./
				             /#     /       ##(*/                *****(#@%%@                               .,///*
				           @.@%%##   @.       %#                  .(. ,%%%%%                                ..//,.
				            @&%@/     /..                       #      ..(#                                  .,//%
				            .     ....                                .,((/                                   .//.
				            (.. ....                                 ,/////                                   .,/,/
				              &@@                                 ,/.*/////                                    %.*@
				,&##@,*                                             *//(//#                                     &*/
				.%%%%@  &.   &                                      *(((((&                                      ..
				  ,...     ..                                      /(((((/(                                      ,.
				    /......#                       ##@%%%          ((((((*                                        #
				       ,..                         ,&%%&&&        ,*(((//&
				        .. .                             ..&    ..,,((((*
				         (,...                    (       ... ....,.(((*@
				           , ...                           ../...,,,((/@
				             @......             .        ...,..,,,***,
				               @................................,,//&
				                  @ .............................@
				                       @,........,.....,..../%
				                                #(/((@

							""";

		String art3 = """
								.................,,,,,,(****(/(**********,,(**,,,,,,,............................................,,,
				................,..,,,,/**////(*****/*****,,/,,,,,,,,,,..,.......................................,,,
				..................,,..,/**//(/(,**********,,***,*/(#(////////////((/(((((((/*.......................
				......................,(*/((((#,**********/((//***********/************///((/((((((,...............,
				.......................(*//((((,,****/((***/*/**/*********************/******//(((((((#/,........,/,
				.......................(/((((((*,*/(/********************************//////***/**//((((((((,.../*,,*
				.......................(/(((((((*(***********************//******//////////*/*//*****//((/((#(,***//
				.......................(///((((#**/********/*************************//////*//***/*//*///((***///*//
				.......................,/((((#/********************************/****///////*////*///*****//*/*/****/
				........................#//(#****/#%(******************************//***///*//////*////****//*/*////
				........................(/#(***#*.,##%**************************************/**/**/////////*/*////*/
				.........................%/**#,....##&/************///***********//****////***/**//////////*/*///**/
				........................,/**%.....(##%/************/**************(&&(/#####%&#*******/*/////***/((#
				........................(*/%#....%@%#%*************************(&#......%######&(*****///*////((((((
				.......................**(&####@@@&#%(*************/*/*******/&(........########%#******//***/*/((((
				.......................((&&#(%&@@@##&/*********************/#&,........,@@%######&(********/*/*//(((
				......................(**/&(/(#%#//&%/**************/******#&#........*@@@&######%#******////***/(((
				.....................(****/%#(/(#&#/**********************(&##/.....*@@@@@%######%%*****/*///*/*/(((
				..................../*********/*************************/%&&####&&@@@@@@@&#######&&****/***///**/(((
				..................,/*************,........,**************/%&%(((#&@@@@@@%#///((#%@@&////***/**/*//((
				..................(*********,.................,************/%&#(//((((((*..////%&&/*//***/*///**/(((
				.................,(*****,........................,*************#&%(/////(*,##&&#**/******//*////*/((
				.................,(**,..............................*************///(###((///*****//****////////*/((
				................../...................................,*******************/*****////**////*/**//*/(/
				.................,,/.............*..........*............*************************************//*//(
				..............,,//,(,(*#*....,*,..,/,**(,....................,,*************************/****////*/(
				.............,//,/,(,/**,(*((*,,**..,*(,................................,****/*************/////////
				.............,,,,,*(/*/**/**..,,,,,/(((.......................................,**/********/*/////**/
				........./&&&&/(((/,,,,.,/*.,,,,,*/(((#/(/(#/(/#/#((,.............................********////***/*/
				.......%&&&&&%*********(/,,,,,,,,,,,,/((#(#/((/(/((/................................,*****////**/***
				....(&&&&&&&#(%,,***,*********,,,......,..,,,**/%/(...............,*..................,*********/***
				....(%%&%#(,,,****##%.//,********,,******,....,*(...............,*......................,******//***
				.,//*/(/.((##,**,,,((%%*,,,,,,,,,*/((/**####(*//............,*............................*/***/*/**
				(,,**/(((((((((/((,/,,,,,(/******(,,,,.#&&&&&&%/.....*/*,..................................**///////
				,///((#(.**/#/((*/((,,,//**//**(**(*,./&&&&&&&&#............................................***///**
				*/(/(//,((*(/,/(((,(/(#*,,,,,,,/**(*,.,%&&&&&%/.............................................,*//****
				/(,,,,,,,/(//*,,,,,,**,,,,,*(/**/*,,,.&%&&&&&*...............................................*/**//*
				////(/,**,,,,,,,.,//*******///*,.,,.,,*(%&&&&,...............................................*/*/*//
				(((((///(((/,,,,,,////*****//*,,,,,.**.////.,/,..............................................**///**
				//#((((((((///////(((/*,,///*(*,*((/,,/*#*........**,........................................**/*/**

								""";

		String art4 = """


				      ⣤⣤⣤⣤⣤⣤⣤⡄⣿⣿⠀⠀⠀⣤⣤⣤⣤⣤⣤⣤⠀⢰⣿⡗⠀⠀⠀⢰⣶⣶⣶⣶⣶⣶⣶⣶⣶⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⣤⣤⣤⣤⣤⣤⠀⠀⢰⣿⡇⠀⠀⠀ ⣀⣤⣶⣶⣶⣶⣶⣤⣄⠀⠀⠀ ⣀⣀⣀⣀⣀⣀⠀⢰⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠉⠉⠉⠁⣿⣿⠀⠀⠀⣿⣿⠉⠉⠉⠉⠉⠀⢸⣿⣇⣀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠉⠉⠉⠉⣹⣿⠀⠀⢸⣿⡇⠀⠀⢰⣿⡏⠀⠀⠀⠀  ⠀⠉⣿⣷⠀⠀⠀⠛⠛⠛⠛⣿⡇⠀⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⢸⣿⠀⠀⣿⣿⠀⠀⠀⣿⣿⣀⣀⣀⣀⣠⡄⢸⣿⡿⠿⠇⠀⠸⠿⠿⠿⢿⣿⡿⠿⠿⠿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⣶⣶⣶⣶⣿⡟⠀⠀⢸⣿⡇⠀⠀⠀⠛⠿⢷⣶⣶⣶⣶⠿⠟⠁⠀⠀ ⠀⠀   ⢸⣿⠇⠀⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀⠀⠀⣿⣷⠀⣾⣿⠀⠀⣿⣿⠿⠇⠀⠿⠿⠿⠟⠛⠛⠛⠃⠸⠿⠇⠀⠀⣤⣤⣤⣤⣤⣼⣿⣧⣤⣤⣤⣤⡄⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⢀⣾⡿⠁⠀⠀⢸⣿⡇⠀⢠⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⠀⠀⠀ ⠀⣠⣿⡟⠀⠀⠀⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀⢀⣀⣸⣿⣀⣿⣿⣤⡄⣿⣿⠀⠀⠀⠀⣶⣶⣶⣶⣶⣶⣶⣶⣶⡆⠀⠀⠉⢩⣭⡍⠉⠉⠉⠉⠉⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⡿⠟⠀⠀⠀⠀⢸⣿⡇⠀⠈⠉⠉⠉⠉⠉⣿⣿⠉⠉⠉⠉⠉⠀⠀⣀⣴⣿⠟⠀⠀⠀ ⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀ ⠀⠘⠟⠛⠛⠛⠛⠉⠉⠉⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡇⠀⠀⠀⢸⣿⣇⣀⣀⣀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠋⠀⠀⠀⠀⠀⠀  ⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⠀⠈⠻⠛⠁⠀⠀⠀⠀⠀ ⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀⠀⠀⠀⠀⠿⠿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠿⠇⠀⠀⠀⠘⠛⠛⠛⠛⠛⠛⠛⠛⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠘⠿⠇⠀⠀⠀⠀⠀⠀⠀⠿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠸⠿⠇⠀⠀⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
				⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀


								""";

		String art5 = """
				 ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄       ▄▄  ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄
				▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░▌     ▐░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌
				▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░▌░▌   ▐░▐░▌▐░█▀▀▀▀▀▀▀▀▀      ▐░█▀▀▀▀▀▀▀▀▀  ▀▀▀▀█░█▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌ ▀▀▀▀█░█▀▀▀▀
				▐░▌          ▐░▌       ▐░▌▐░▌▐░▌ ▐░▌▐░▌▐░▌               ▐░▌               ▐░▌     ▐░▌       ▐░▌▐░▌       ▐░▌     ▐░▌
				▐░▌ ▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄█░▌▐░▌ ▐░▐░▌ ▐░▌▐░█▄▄▄▄▄▄▄▄▄      ▐░█▄▄▄▄▄▄▄▄▄      ▐░▌     ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌     ▐░▌
				▐░▌▐░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌  ▐░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌     ▐░▌     ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░▌
				▐░▌ ▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░▌   ▀   ▐░▌▐░█▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀█░▌     ▐░▌     ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀█░█▀▀      ▐░▌
				▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌                         ▐░▌     ▐░▌     ▐░▌       ▐░▌▐░▌     ▐░▌       ▐░▌
				▐░█▄▄▄▄▄▄▄█░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄█░▌     ▐░▌     ▐░▌       ▐░▌▐░▌      ▐░▌      ▐░▌
				▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌     ▐░▌     ▐░▌       ▐░▌▐░▌       ▐░▌     ▐░▌
				 ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀▀▀       ▀       ▀         ▀  ▀         ▀       ▀



							""";
		
		String art7 = """
 //////////**********,************,,,,,,,,,,,,,,,,,,,*************,*******///////
/////////********,************,,,,,,,,,,,,,,,,,,,,,**********************///////
/////****/*****,**********,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,**********,*****//////
*************,****//****,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,*********,*****/////
///********,***////***,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,*********/,*****/////
////*****,***/////,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,****.******,,*****////
///****,***///,,,,*,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,**********,********/
////*****//*,,,,,*/*,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,********/,********/
/******/(*,,,,,**,**/(/,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,*******,********/
(((((((/......,****,,,* /*/,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,*****,********/
#####(/......,.,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,******//,********/
//(#(/,.......,...,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,********//,********/
/**/(,,......,,*,....              ,,,,,,,,////*,,,,,,,,,,*********///,*******//
//***,,.....,,,,,,,...                .,,,,,,,,///((((*************//*,*******//
///**,,,...,,,,,(((/,..                  ,,,,,,,,,*,***  ///(*****///,,******///
/////(((*//*(/(((((((/,,.. *,               ,,,,,,,,,,***********////,,*****////
////(((((((((((((((((((((/,,.                    ,,,,,,,*******////,*,***///////
////////((((/****,,((((((((((//,,,..         ...............*.....,,*,*//(((////
							"""; 
		String art8 = """
@&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
&............**,...................................,,,,,,,,,,,,,,,,,************
&  . .  .*,..../.. . . . . . ..................,,,,,,,,..,,,,,.,,,,,,*/...*(**,,
&    ./,...,,../ ... ............................,,,,,,,,,,,,,,,,,,,,*,.,,..,/,,
&  ,*...*,*,,../... .........................,..,,,,,,,********,,,,,,/.,,,,,..,/
&*,..*((**/(*,./..........................,,,,,,,,,,,,,,,,,,,,,,,,,,/,,,***#/*,.
&.,*///***//*,./.. . . .   . ......................,,,,,,,,,,,,,,,,*,,,*(/**/((*
&**//***////,,./.                        .....................,,,,,/,,,(///*,*//
&*//***//*//*,.,,                            ...................,,*,*,//*****,**
&*/**********,,.,...   ............. ............................*,*,***,,******
&**,,*,,,*,***,,.*.......................................... ...*,,,,*,*,*,*,*,,
&**,,,,,,*,****,..,,........................ ... ... ... ... ..*.,,,,,**,,,,,*,,
&,*,,,,,,,,,,,,,,...*........                                .*.,,,,,,,,,,**,,,*
&,**,,**,***,***,*,...*. ...             ..   .. ... ... ....*.,,*,,,,,,,,**,***
&***,*,*,*,***,***,*,,..,,.. . . .     ....................,*,,,,,,*,*****,,,*,*
&***,***,***********,***,,,**.....,*((((((((((((/,,,.,,,,,*,,,,,*,,,,****,,....,
&,**,,,,,,,,,,,,,**,*,,,,,,,,,,/*,***,,,,,,,,,,,,,,,,*/**/,,,***/(/*,,,,,,,.....
&,**,,,,,**,,,,,*,*/((*../#(****,*******,,,*,***,***,****,***/,,,,,(****,**,....
&,.......,,*,*,*/((,..,////******,,*,,,*,,,*,*,*,*,*,*,*,,,,*/*,,,,,//,*,*,,./*/
&........,,,,**((...,///*,**********************,***,***,,,**,*(,,,,,,/*****./,.
&....*/*.,,,*/(....///***,,*&@( .**,*,,*********,,,,,,,,,,*%%/,,/,....,/*,,,,/..
&.,*....,*,*(*,..,(//*****%&(#    */,,*,************,*,,**  ((%&*(......****,/..
&,       /*(.....(/******&%##@@@@@@%#*,*************,,**,  *@%#%@**......***,/..
& .      ./ ....(/*****(@@#(%@@@@@@%#&#*************,*##&@@@@@(/@#(,,,,,,,*/,/,,
&    .   ...  .///*******%&/*/%&&,,//@(*******,,*****#@(#@@@@(*#&***,..,,,,**/,,
&  ..... . . .*//*,,,***,**#@#/*///%@@/***,,..  ...,,,/&(*////%%,****,.,...,,/..
&  ... . .  .,//***,,,,,,,,,,*,,***,,,.                .,,,**,**,*,,*....,*,,,,.
&............(//*,.                          ,*,                    ............
&...........*/*.                                                    /........,..
&          .*..                                                   ,(**,,,,,,,,,,
&    .   .,.                                                    ,..*,,,,,,,,,,,,
& .  . ..*.                                                  .       *,,,,,,,,,,
&   ..  .,      .*/&%%.                                         .,.   .,........
&........,       (%&&%                                        (&&&&(,, *........
&........*..      #&&*                                         %&&&,   ,........
&......../(,       ,                                           ,       , .......
&       //.   .                                                 .,,..,,.........
&      .(,                                                        ,.............
&      /*.                                                         *. .... .....
&  .,**#..                                                         .(//*.    ...
@((((((/..                                                          *//((/. ..  
@(((((#,..                                                           ((((((/(/,.
@((((((* .                                                           (((/////(/(
@(((((((. ...                                                       ///((((//(/.
@((((((((... .                                                     ((/////////. 
@((((((&@@#. ..      ..       .  .....**//*. . .                 (&&&&((((((*.  
&. .  .&@@@@@&*..       ...,(###((((((((((/((##%%(*,.......,/#&&&&&&&*          
&...  .  .,,. ..  ...,,,,,,.....           .,,....       ...       .            
& .                                                          ..,.....           
											"""; 

		for (int i = 0; i < art4.length(); i++) {
			System.out.print(art4.charAt(i));
//			Thread.sleep(2);
		}

		for (int i = 0; i < art.length(); i++) {
			System.out.print(art.charAt(i));
//			Thread.sleep(2);
		}

		for (int i = 0; i < art5.length(); i++) {
			System.out.print(art5.charAt(i));
//			Thread.sleep(2);
		}
		System.out.println("[파닥몬 키우기 로그인창]");
		System.out.println("파닥몬 키우기 로그인을 해주세요");
		System.out.println("[1]회원가입하기 [2]로그인하기 [3]종료");

		while (true) {
			int menu = sc.nextInt();
			if (menu == 1) {
				System.out.println("==회원 가입==");

				System.out.println("ID를 입력해주세요 >> ");
				String id = sc.next();
				System.out.println("pw를 입력해주세요 >> ");
				String pw = sc.next();
				System.out.println("이름을 입력해주세요 >> ");
				String name1 = sc.next();

				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					String user = "hr";
					String password = "hr";

					conn = DriverManager.getConnection(url, user, password);

					String searchQuery = "select u_id, u_pw from ur where u_id= ?";
					psmt = conn.prepareStatement(searchQuery);
					psmt.setString(1, id);
					rs = psmt.executeQuery();
					if (rs.next() == true) {
						System.out.println("이미 아이디 값이 있습니다.");
						isSearch = true;
						System.out.println("[1]회원가입하기 [2]로그인하기 [3]종료");
					}

					if (isSearch == false) {

						String insertQuery = "insert into ur values(?, ?, ?)";

						psmt = conn.prepareStatement(insertQuery);
						psmt.setString(1, id);
						psmt.setString(2, pw);
						psmt.setString(3, name1);
						row = psmt.executeUpdate();
						if (row > 0) {
							System.out.println("회원가입 성공!!!!");
							System.out.println("[1]회원가입하기 [2]로그인하기 [3]종료");
						} else {
							System.out.println("회원가입 실패!!!!");
						}

					}

				} catch (ClassNotFoundException e) {
					System.out.println("드라이버 로딩 오류");
					e.printStackTrace();
				} catch (SQLException e) {
					System.out.println("연결 실패");
					e.printStackTrace();
				} finally {
					try {
						if (psmt != null)
							psmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						System.out.println("반납 오류");
						e.printStackTrace();
					}
				}

			} else if (menu == 2) {

				System.out.println("로그인하기");
				System.out.print("ID 입력 >> ");
				String id = sc.next();
				System.out.print("PW 입력 >> ");
				String pw = sc.next();
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					String user = "hr";
					String password = "hr";
					conn = DriverManager.getConnection(url, user, password);
					String sql = "select * from ur where u_id = ? and u_pw = ? ";
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, id);
					psmt.setString(2, pw);
					rs = psmt.executeQuery();
					if (rs.next()) {
						System.out.println("로그인 성공!");
						String name = rs.getString("d_name");
						System.out.println("반가워요!!!" + name + "님");
						isStart = true;
						break;
					} else {
						System.out.println("로그인 실패");
						System.out.println("[1]회원가입하기 [2]로그인하기 [3]종료");
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (psmt != null)
							psmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} else if (menu == 3) {
				System.out.println("게임을 종료합니다.");
				break;
			} else {
				System.out.println("다시입력해주세요");
			}
		}
		System.out.println("게임시작!!");

		if (isStart == true) {
			System.out.println("파닥몬 키우기를 시작합니다^^");

		}
		// dmon생성자
		System.out.println("파닥몬의 이름을 입력해주세요 >> ");
		String name1 = sc.next();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";

			conn = DriverManager.getConnection(url, user, password);

			String insertQuery = "insert into dmon values(1, 50, '기분 좋아요~', ?,0,sysdate,100,100)";
			psmt = conn.prepareStatement(insertQuery);
			psmt.setString(1, name1);
			row = psmt.executeUpdate();
			if (row > 0) {
				System.out.println("파닥몬 생성 성공!!!!");
			} else {
				System.out.println("파닥몬 생성 실패!!!!");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 오류");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("반납 오류");
				e.printStackTrace();
			}
		}
		
		int i = 0;

		while (true) {
			if (i == 0) {
				System.out.println(name1);
				statusDTO dto1 = new statusDTO(name1);
				dto1 = controller.show(dto1);
				if (dto1.getHgr() <= 50 && dto1.getSlp() <= 50) {
					dto1.setCon("배고파요 ㅜㅜ 피곤해요 ㅜㅜ");
				} else if (dto1.getHgr() <= 50) {
					dto1.setCon("배고파요 ㅜㅜ~");
				} else if (dto1.getSlp() <= 50) {
					dto1.setCon("피곤해요 ㅜㅜ");
				} else if (dto1.getHgr() > 50 && dto1.getSlp() > 50) {
					dto1.setCon("기분 좋아요~");
				}
				if (dto1.getHgr() <= 50 || dto1.getSlp() <= 50) {
					System.out.println(art2);
				} else if (dto1.getCon().equals("기분 좋아요~")) {
					System.out.println(art6);
				}
				System.out.println("========================================");
				System.out.println("Name : " + dto1.getName());
				System.out.println("Lv : " + dto1.getLv());
				System.out.println("Hp : " + dto1.getHp());
				System.out.println("Condition : " + dto1.getCon());
				System.out.println("Hungry : " + dto1.getHgr());
				System.out.println("Fatigue : " + dto1.getSlp());

				System.out.println("[1]밥 먹이기 || [2]잠자기 || [3]전투하기 || [4] 타이틀로 돌아가기");
				i = sc.nextInt();
			}
			if (i == 1) {
				statusDTO dto1 = new statusDTO(name1);
				dto1 = controller.show(dto1);
				System.out.println(dto1.getName() + "이(가) 밥을 먹습니다");

				System.out.println();

				dto1.setHgr(dto1.getHgr() + 2); // 이거 확인
				System.out.println(art3);
				System.out.println();
				System.out.println("배고픔 회복 !!!");
				System.out.println("=================");
				System.out.println("파닥몬 포만감 수치 : " + dto1.getHgr());
				System.out.println("메인화면으로 돌아가기 >> (Y,N)");
				String sel1 = sc.next();
				if (sel1.equals("Y")) {
					i = 0;
				} else if (sel1.equals("N")) {
					System.out.println("대기중");

				}
			}
			if (i == 2) {
				statusDTO dto1 = new statusDTO(name1);
				dto1 = controller.show(dto1);
				System.out.println(dto1.getName() + "이(가) 잠을 잡니다.");
				dto1.setSlp(dto1.getSlp() + 2);
				System.out.println(art7);
				System.out.println("피곤함 회복 !!!");
				System.out.println("=================");
				System.out.println("파닥몬 활동력 수치 : " + dto1.getSlp());
				System.out.println("메인화면으로 돌아가기 >> (Y/N)");
				String sel2 = sc.next();
				if (sel2.equals("Y")) {
					i = 0;
				}
			}
			if (i == 3) {
				statusDTO dto1 = new statusDTO(name1);
				dto1 = controller.show(dto1);
				System.out.println(art8);
				System.out.println(dto1.getName() + "이(가) 전투를 시작합니다.");
				System.out.println("메인화면으로 돌아가기 >> (Y/N)");
				String sel3 = sc.next();
				if (sel3.equals("Y")) {
					i = 0;
				}
			}
			if (i == 4) {
				System.out.println("타이틀로 돌아가시겠습니까? >> (Y/N)");
				String exit = sc.next();
				if (exit.equals("Y")) {
					System.out.println("타이틀로 돌아갑니다.");
					break;
				}

			}
		}
	}
}
