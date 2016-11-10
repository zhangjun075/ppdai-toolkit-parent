package com.ppdai.exception.consts;

import com.ppdai.exception.enums.ExceptionSeverityEnum;

public interface ExceptionConsts {

  /** ExceptionConsts UnknownCode unknown */
  public final static String UnknownCode = "unknown";

  /** ExceptionConsts UnknownText unknown */
  public final static String UnknownMessage = "unknown";

  /** ExceptionConsts ModuleBusiness business */
  public final static String ModuleBusiness = "business";

  /** ExceptionConsts ModuleSystem system */
  public final static String ModuleSystem = "system";

  /** ExceptionConsts ModuleRemote remote */
  public final static String ModuleRemote = "remote";

  /** ExceptionConsts ExceptionSeverity SeveritySlight */
  public final static ExceptionSeverityEnum SeveritySlight = ExceptionSeverityEnum.Slight;

  /** ExceptionConsts ExceptionSeverity SeverityMiddle */
  public final static ExceptionSeverityEnum SeverityMiddle = ExceptionSeverityEnum.Middle;

  /** ExceptionConsts ExceptionSeverity SeverityCritical */
  public final static ExceptionSeverityEnum SeverityCritical = ExceptionSeverityEnum.Critical;

  /** manual = 1 if the exception need manual fix, manual fixed = 2, no need = 0 */
  public final static short manual = 0;

}
