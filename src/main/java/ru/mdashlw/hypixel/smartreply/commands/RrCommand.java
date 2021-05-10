/*
 * MIT License
 *
 * Copyright (c) 2020 mdashlw
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package ru.mdashlw.hypixel.smartreply.commands;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;

public final class RrCommand implements ICommand {

  @Override
  public String getCommandName() {
    return "rr";
  }

  @Override
  public String getCommandUsage(final ICommandSender sender) {
    return null;
  }

  @Override
  public List<String> getCommandAliases() {
    return Collections.emptyList();
  }

  @Override
  public void processCommand(final ICommandSender sender, final String[] args) {
    ((EntityPlayerSP) sender).sendChatMessage("/r " + String.join(" ", args));
  }

  @Override
  public boolean canCommandSenderUseCommand(final ICommandSender sender) {
    return true;
  }

  @Override
  public List<String> addTabCompletionOptions(final ICommandSender sender, final String[] args, final BlockPos pos) {
    return null;
  }

  @Override
  public boolean isUsernameIndex(final String[] args, final int index) {
    return false;
  }

  @Override
  public int compareTo(final ICommand o) {
    return 0;
  }
}
