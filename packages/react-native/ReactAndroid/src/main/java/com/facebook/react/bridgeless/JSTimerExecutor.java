/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.react.bridgeless;

import com.facebook.infer.annotation.Nullsafe;
import com.facebook.jni.HybridData;
import com.facebook.jni.annotations.DoNotStrip;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.modules.core.JavaScriptTimerExecutor;
import com.facebook.soloader.SoLoader;
import com.facebook.soloader.annotation.SoLoaderLibrary;

@Nullsafe(Nullsafe.Mode.LOCAL)
@SoLoaderLibrary("rninstance")
public class JSTimerExecutor implements JavaScriptTimerExecutor {

  static {
    SoLoader.loadLibrary("rninstance");
  }

  @DoNotStrip private HybridData mHybridData;

  public JSTimerExecutor(HybridData hybridData) {
    mHybridData = hybridData;
  }

  @Override
  public void callTimers(WritableArray timerIDs) {
    callTimers((WritableNativeArray) timerIDs);
  }

  private native void callTimers(WritableNativeArray timerIDs);

  @Override
  public void callIdleCallbacks(double frameTime) {
    // TODO T52558331
  }

  @Override
  public void emitTimeDriftWarning(String warningMessage) {
    // TODO T52558331
  }
}
