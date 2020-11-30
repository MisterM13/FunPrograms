import java.text.SimpleDateFormat;  
import java.util.Date;  

/*
AdventCalendar by MisterM13, have Fun!
 
	Features:
	- every day new Colors
	- automatic day recognance
	- a st.nicolaus special
*/

class AdventCalendar {
static int day;
static	String line1  = "\033[0;30m                                                  *                                                  \n";
static	String line2  = "\033[0;30m                                                 .^.                                                 \n";
static	String line3  = "\033[0;30m                                                /AohA                                                \n";
static	String line4  = "\033[0;30m                                               /-<|>-A                                               \n";
static	String line5  = "\033[0;30m                                              /__/*_|-A                                              \n";
static	String line6  = "\033[0;30m                                             /#hohoho#-A                                             \n";
static	String line7  = "\033[0;30m                                            /|-%_|x|_&:-A                                            \n";
static	String line8  = "\033[0;30m                                               /-0Y0-A                                               \n";
static	String line9  = "\033[0;30m                                              /_|xOx|_A                                              \n";
static	String line10 = "\033[0;30m                                             /|_o/VA%-yA                                             \n";
static	String line11 = "\033[0;30m                                            /x0lx|X|_xvbA                                            \n";

static	String line12 = "\033[0;30m                                           /-|M|_o^0?-12zA                                           \n";
static	String line13 = "\033[0;30m                                          /|-0xo|eVx0|-/.-A                                          \n";
static	String line14 = "\033[0;30m                                         /<0>-/.o|X|R*-/<|>A                                         \n";
static	String line15 = "\033[0;30m                                           /->R-|0T0x|y()A                                           \n";
static	String line16 = "\033[0;30m                                          />!<|voXYX/0c(*)A                                          \n";
static	String line17 = "\033[0;30m                                         /{xy}0=C<|>X?{17}(A                                         \n";
static	String line18 = "\033[0;30m                                        /(R)={18}-0+Xo|Vf:-)A                                        \n";
static	String line19 = "\033[0;30m                                       /Xv>>-/lW;-I-<|*>(xY)|A                                       \n";
static	String line20 = "\033[0;30m                                      /Vy<_>|XS->(#)>0>|{#}-o:A                                      \n";
static	String line21 = "\033[0;30m                                     /-:->_|*<|><%T%x:=o+21_y;-A                                     \n";
static	String line22 = "\033[0;30m                                                 MXM                                                 \n";
static	String line23 = "\033[0;30m                                                 NAN                                                 \n";
static	String line24 = "\033[0;30m                                                 S0S                                                 \n";

static	String line1a  = "\033[0;37m                                                  *                                                   \033[0m \n";
static	String line2a  = "                                                 \033[0;36m.\033[0;32m^\033[0;36m.\033[0m                                                 \n";
static	String line3a  = "\033[0;32m                                                /A\033[0;36mo\033[0;32mhA                                                \n";
static	String line4a  = "\033[0;32m                                               /-\033[0;33m<\033[0;32m|\033[0;33m>\033[0;32m-A                                               \n";
static	String line5a  = "\033[0;32m                                              /__/\033[1;34m*\033[0;32m_|-A                                              \n";
static	String line6a  = "\033[0;32m                                             /#\033[0;31mhohoho\033[0;32m#-A                                             \n";
static	String line7a  = "\033[0;32m                                            /|-\033[0;35m%\033[0;32m_|\033[0;35mx\033[0;32m|_\033[0;35m&\033[0;32m:-A                                            \n";
static	String line8a  = "\033[0;32m                                               /-\033[0;34m0\033[0;32mY\033[0;34m0\033[0;32m-A                                               \n";					
static	String line9a  = "\033[0;32m                                              /_|x\033[0;33mO\033[0;32mx|_A                                              \n";
static	String line10a = "\033[0;32m                                             /|_\033[0;36mo\033[0;32m/VA\033[0;36m%\033[0;32m-yA                                             \n";
static	String line11a = "\033[0;32m                                            /x\033[0;35m0\033[0;32mlx|X|_xvbA                                            \n";
static	String line12a = "\033[0;32m                                           /-|M|_\033[0;31mo\033[0;32m^\033[0;31m0\033[0;32m?-\033[0;33m12\033[0;32mzA                                           \n";
static	String line13a = "\033[0;32m                                          /|-\033[0;33m0\033[0;32mx\033[0;33mo\033[0;32m|eVx\033[0;33m0\033[0;32m|-/.-A                                          \n";
static	String line14a = "\033[0;32m                                         /<\033[1;34m0\033[0;32m>-/.\033[1;34mo\033[0;32m|X|R\033[1;34m*\033[0;32m-/<|>A                                         \n";
static	String line15a = "\033[0;32m                                           /->R-|\033[0;36m0\033[0;32mT\033[0;36m0\033[0;32mx|y()A                                           \n";
static	String line16a = "\033[0;32m                                          />!<|v\033[0;35mo\033[0;32mXYX/\033[0;35m0\033[0;32mc(*)A                                          \n";
static	String line17a = "\033[0;32m                                         /{xy}\033[0;37m0\033[0;32m=C<|>X?{\033[0;37m17\033[0;32m}(A                                         \n";
static	String line18a = "\033[0;32m                                        /(R)={\033[0;33m18\033[0;32m}-\033[0;31m0\033[0;32m+Xo|Vf\033[0;33m:-)\033[0;32mA                                        \n";
static	String line19a = "\033[0;32m                                       /Xv\033[0;36m>>\033[0;32m-/lW;-I-<|\033[0;36m*\033[0;32m>(xY)|A                                       \n";
static	String line20a = "\033[0;32m                                      /Vy<_>|XS->(#)>\033[0;34m0\033[0;32m>|{#}-\033[0;34mo\033[0;32m:A                                      \n";
static	String line21a = "\033[0;32m                                     /-:->_|\033[0;31m*\033[0;32m<|><%T%x:=\033[0;31mo\033[0;32m+\033[0;37m21\033[0;32m_y;-A                                     \n";
static	String line22a = "\033[0;32m                                                 \033[0;31mM\033[0;32mX\033[0;31mM\033[0;32m                                                 \n";
static	String line23a = "\033[0;32m                                                 N\033[0;34mA\033[0;32mN                                                 \n";
static	String line24b = "\033[0;32m                                                 S0\033[0;103m\033[1;31mS\033[0m                                                 \n";
static	String line12b = "\033[0;32m                                           /-|\033[0;103m\033[1;31mM\033[0m|_\033[0;31mo\033[0;32m^\033[0;31m0\033[0;32m?-\033[0;33m12\033[0;32mzA                                           \n";
static	String line13b = "\033[0;32m                                          /|-\033[0;33m0\033[0;32mx\033[0;33mo\033[0;32m|\033[0;103m\033[1;31me\033[0m\033[0;32mVx\033[0;33m0\033[0;32m|-/.-A                                          \n";
static	String line14b = "\033[0;32m                                         /<\033[1;34m0\033[0;32m>-/.\033[1;34mo\033[0;32m|X|\033[0;103m\033[1;31mR\033[0m\033[1;34m*\033[0;32m-/<|>A                                         \n";
static	String line15b = "\033[0;32m                                           /->\033[0;103m\033[1;31mR\033[0m\033[0;32m-|\033[0;36m0\033[0;32mT\033[0;36m0\033[0;32mx|y()A                                           \n";
static	String line16b = "\033[0;32m                                          />!<|v\033[0;35mo\033[0;32mX\033[0;103m\033[1;31mY\033[0m\033[0;32mX/\033[0;35m0\033[0;32mc(*)A                                          \n";
static	String line17b = "\033[0;32m                                         /{xy}\033[0;37m0\033[0;32m=\033[0;103m\033[1;31mC\033[0m\033[0;32m<|>X?{\033[0;37m17\033[0;32m}(A                                         \n";
static	String line18b = "\033[0;32m                                        /(\033[0;103m\033[1;31mR\033[0m\033[0;32m)={\033[0;33m18\033[0;32m}-\033[0;31m0\033[0;32m+Xo|Vf\033[0;33m:-)\033[0;32mA                                        \n";
static	String line19b = "\033[0;32m                                       /Xv\033[0;36m>>\033[0;32m-/lW;-\033[0;103m\033[1;31mI\033[0m\033[0;32m-<|\033[0;36m*\033[0;32m>(xY)|A                                       \n";
static	String line20b = "\033[0;32m                                      /Vy<_>|X\033[0;103m\033[1;31mS\033[0m\033[0;32m->(#)>\033[0;34m0\033[0;32m>|{#}-\033[0;34mo\033[0;32m:A                                      \n";
static	String line21b = "\033[0;32m                                     /-:->_|\033[0;31m*\033[0;32m<|><%\033[0;103m\033[1;31mT\033[0m\033[0;32m%x:=\033[0;31mo\033[0;32m+\033[0;37m21\033[0;32m_y;-A                                     \n";
static	String line22b = "\033[0;32m                                                 \033[0;103m\033[1;31mM\033[0m\033[0;32mX\033[0;31mM\033[0;32m                                                 \n";
static	String line23b = "\033[0;32m                                                 N\033[0;103m\033[1;31mA\033[0m\033[0;32mN                                                 \n";
	
	public static void openDoor(int day){
		StringBuilder bob = new StringBuilder();
		boolean christmas = false;
		if (day > 23) {
			christmas = true;
		}
		if (day > 0) {
			bob.append(line1a);
			if (day > 1) {
				bob.append(line2a);
				if (day > 2) {
					bob.append(line3a);
					if (day > 3) {
						bob.append(line4a);
						if (day > 4) {
							bob.append(line5a);
							if (day > 5) {
								bob.append(line6a);
								if (day > 6) {
									bob.append(line7a);
									if (day > 7) {
										bob.append(line8a);
										if (day > 8) {
											bob.append(line9a);
											if (day > 9) {
												bob.append(line10a);
												if (day > 10) {
													bob.append(line11a);
													if (day > 11) {
														if (christmas) {
															bob.append(line12b);
															bob.append(line13b);
															bob.append(line14b);
															bob.append(line15b);
															bob.append(line16b);
															bob.append(line17b);
															bob.append(line18b);
															bob.append(line19b);
															bob.append(line20b);
															bob.append(line21b);
															bob.append(line22b);
															bob.append(line23b);
															bob.append(line24b);
														} else {
															bob.append(line12a);
															if (day > 12) {
																bob.append(line13a);
																if (day > 13) {
																	bob.append(line14a);
																	if (day > 14) {
																		bob.append(line15a);
																		if (day > 15) {
																			bob.append(line16a);
																			if (day > 16) {
																				bob.append(line17a);
																				if (day > 17) {
																					bob.append(line18a);
																					if (day > 18) {
																						bob.append(line19a);
																						if (day > 19) {
																							bob.append(line20a);
																							if (day > 20) {
																								bob.append(line21a);
																								if (day > 21) {
																									bob.append(line22a);
																									if (day > 22) {
																										bob.append(line23a);
																										bob.append(line24);
																									} else {
																										bob.append(line23);
																										bob.append(line24);
																									}
																								} else {
																									bob.append(others());
																								}
																							} else {
																								bob.append(others());
																							}
																						} else {
																							bob.append(others());
																						}
																					} else {
																						bob.append(others());
																					}
																				} else {
																					bob.append(others());
																				}
																			} else {
																				bob.append(others());
																			}
																		} else {
																			bob.append(others());
																		}
																	} else {
																		bob.append(others());
																	}
																} else {
																	bob.append(others());
																}
															} else {
																bob.append(others());
															}
														}
													} else {
														bob.append(others());
													}
												} else {
													bob.append(others());
												}
											} else {
												bob.append(others());
											}
										} else {
											bob.append(others());
										}
									} else {
										bob.append(others());
									}
								} else {
									bob.append(others());
								}
							} else {
								bob.append(others());
							}
						} else {
							bob.append(others());
						}
					} else {
						bob.append(others());
					}
				} else {
					bob.append(others());
				}
			} else {
				bob.append(others());
			}
		} else {
			bob.append(others());
		}
	System.out.print(bob.toString());	
	}
	
	private static String others(){
		StringBuilder bill = new StringBuilder();
		String[] other = new String[]{line1, line2, line3, line4, line5,line6,line7,line8, line9,line10,line11,line12,line13,
		line14,line15,line16,line17, line18, line19,line20,line21,line22,line23,line24};
		for (int i =day; i < 24; i++) {
				bill.append(other[i]);
		}
		return bill.toString();
	}
	
	public static int date(){
		int dayX;
		SimpleDateFormat formatter = new SimpleDateFormat("MMdd");  
			Date date = new Date();  
			int dayx = Integer.parseInt(formatter.format(date));
			//System.out.println(dayx);
			if (dayx-1200 < 0) {
				dayX=0;
			}else {
				dayX=dayx-1200;
			}
			return dayX;
	} 
	
	public static void main(String[] args) {
		day = date();
		//System.out.println(day);
		try {
			day = Integer.parseInt(args[0]);
		} catch (Exception e) {
		}
		//TEST
		/*for (int x = 0; x <=24;x++) {
			day = x;
			System.out.println("\033[0mTest Day: "+x);
			openDoor(day);
			
		}*/
		openDoor(day);
		
	}
}